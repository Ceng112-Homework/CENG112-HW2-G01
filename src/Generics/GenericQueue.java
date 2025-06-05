package Generics;

import Interfaces.ListInterface;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// generic queue implementation using a linked list
public class GenericQueue<T> implements QueueInterface<T> {

    // Using a linked list as the underlying data structure
    private final ListInterface<T> queue;

    // Constructor initializes the queue
    public GenericQueue() {
        queue = new LinkedList<>();
    }

    // method for adding an entry to the queue
    public void enqueue(T newEntry) {
        queue.add(newEntry);
    }

    // method for removing an entry from the queue
    public T dequeue() {
        return queue.remove(1);
    }

    // method for getting the front entry of the queue without removing it
    public T getFront() {
        return queue.getEntry(1);
    }

    // method for checking if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // method for getting all entries in the queue as a list
    public List<T> getAll() {
        return new ArrayList<>(Arrays.asList(queue.toArray()));
    }

    // method for clearing the queue
    public void clear() {
        queue.clear();
    }

    // method for displaying the contents of the queue
    public String display() {

        // Using StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        Object[] arr = queue.toArray();
        for (Object obj: arr) {
            String str = obj.toString();
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}
