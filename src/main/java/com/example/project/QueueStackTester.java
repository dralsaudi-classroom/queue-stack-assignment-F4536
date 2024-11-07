package com.example.project;

public class QueueStackTester {
   public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
    // Call the helper method with an initial position counter (1 for the first element)
    splitHelper(q, oq, eq, 1);
}

private static <T> void splitHelper(Queue<T> q, Queue<T> oq, Queue<T> eq, int position) {
    // Base case: If the queue is empty, return
    if (q.isEmpty()) {
        return;
    }

    // Dequeue the front element
    T element = q.poll();

    // Place element in odd queue (oq) or even queue (eq) based on position
    if (position % 2 != 0) {
        oq.add(element); // Odd position, add to oq
    } else {
        eq.add(element); // Even position, add to eq
    }

    // Recur for the next element
    splitHelper(q, oq, eq, position + 1);

    // Re-enqueue the element to the original queue to restore its state
    q.add(element);
}

    }
   public static <T> void remove(LinkedPQ<T> pq, int p) {
    Node<T> current = pq.head;
    Node<T> previous = null;

    while (current != null) {
        // Check if the current node's priority is less than p
        if (current.priority < p) {
            if (previous == null) {
                // If removing the head element
                pq.head = current.next;
            } else {
                // Skip the current node
                previous.next = current.next;
            }
            // Move to the next node
            current = current.next;
        } else {
            // Move to the next node, keeping track of previous
            previous = current;
            current = current.next;
        }
    }
}

    }
 public static <T> boolean search(Stack<T> st, T e) {
    // Base case: If the stack is empty, the element is not found
    if (st.isEmpty()) {
        return false;
    }

    // Pop the top element to inspect it
    T topElement = st.pop();

    // If the top element is the one we are looking for, return true
    if (topElement.equals(e)) {
        // Push the element back before returning to keep the stack unchanged
        st.push(topElement);
        return true;
    }

    // Recursively search in the rest of the stack
    boolean found = search(st, e);

    // Push the element back to restore the original stack state
    st.push(topElement);

    return found;
}

}
