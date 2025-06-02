package Generics;

import Interfaces.ListInterface;
import Interfaces.QueueInterface;

public class GenericQueue<T> implements QueueInterface<T> {
    /**
     * A generic queue implementation using a linked list.
     * This class implements the QueueInterface and provides methods
     * to enqueue, dequeue, check the front element, check if the queue is empty,
     * and clear the queue.
     */

    private final ListInterface<T> queue;

    public GenericQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Add a new entry to the queue.
     * @param newEntry The entry to be added.
     */
    public void enqueue(T newEntry) {
        queue.add(newEntry);
    }

    /**
     * Remove the first item in the queue.
     * @return The removed item.
     */
    public T dequeue() {
        return queue.remove(1);
    }

    /**
     * Observe the first item in the queue without removing.
     * @return The first item in the queue.
     */
    public T getFront() {
        return queue.getEntry(1);
    }

    /**
     * Check if the queue is empty.
     * @return true if queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * @return The array of the items in the queue
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        return queue.toArray();
    }

    /**
     * Clear the queue.
     */
    public void clear() {
        queue.clear();
    }

    /**
     * Returns a string representation of the queue.
     * This method iterates through the queue and appends each element to a StringBuilder.
     * @return A string containing all elements in the queue, separated by spaces.
     */
    public String display() {
        StringBuilder sb = new StringBuilder();
        Object[] arr = queue.toArray();
        for (Object obj: arr) {
            String str = obj.toString();
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}
