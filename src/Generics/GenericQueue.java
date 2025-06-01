package Generics;

import Interfaces.QueueInterface;

public class GenericQueue<T> implements QueueInterface<T> {
    /**
     * A generic queue implementation using a linked list.
     * This class implements the QueueInterface and provides methods
     * to enqueue, dequeue, check the front element, check if the queue is empty,
     * and clear the queue.
     */

    private Node firstNode;
    private Node lastNode;
    private int numberOfItems;

    public GenericQueue() {
        clear();
    }

    /**
     * Add a new entry to the queue.
     * @param newEntry The entry to be added.
     */
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        numberOfItems++;
    }

    /**
     * Remove the first item in the queue.
     * @return The removed item.
     */
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNextNode();

            if (firstNode == null)
                lastNode = null;

            numberOfItems--;
        }
        return front;
    }

    /**
     * Observe the first item in the queue without removing.
     * @return The first item in the queue.
     */
    public T getFront() {
        if (isEmpty()) {
            /*throw new Exception("Queue is empty");*/
            return null; // Return null if the queue is empty
        } else {
            return firstNode.getData();
        }
    }

    /**
     * Check if the queue is empty.
     * @return true if queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    /**
     * @return The array of the items in the queue
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        if (isEmpty()) {
            return (T[]) java.lang.reflect.Array.newInstance(Comparable.class, 0);
        }

        T sample = firstNode.getData();
        T[] items = (T[]) java.lang.reflect.Array.newInstance(sample.getClass(), numberOfItems);

        Node currentNode = firstNode;
        for (int i = 0; i < numberOfItems; i++) {
           items[i] = currentNode.getData();
           currentNode = currentNode.getNextNode();
        }
        return items;
    }

    /**
     * Clear the queue.
     */
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfItems = 0;
    }

    /**
     * Returns a string representation of the queue.
     * This method iterates through the queue and appends each element to a StringBuilder.
     * @return A string containing all elements in the queue, separated by spaces.
     */
    public String display() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString().trim();
    }

    private class Node {
        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node getNextNode() {
            return next;
        }

        void setNextNode(Node next) {
            this.next = next;
        }

        T getData() {
            return data;
        }

        void setData(T data) {
            this.data = data;
        }
    }
}
