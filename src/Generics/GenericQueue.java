package Generics;

import Interfaces.QueueInterface;

public class GenericQueue<T> implements QueueInterface<T> {
    /**
     * A generic queue implementation using an array.
     * This class implements the QueueInterface and provides methods
     * to enqueue, dequeue, check the front element, check if the queue is empty,
     * and clear the queue.
     */

    private Node firstNode;
    private Node lastNode;

    public GenericQueue() {
        firstNode = null;
        lastNode = null;
    }
    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    public T dequeue() {
        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null; // If the queue is now empty, reset lastNode
        }
        return front;
    }

    public T getFront() {
        if (isEmpty()) {
            /*throw new Exception("Queue is empty");*/
            return null; // Return null if the queue is empty
        } else {
            return firstNode.getData();
        }
    }

    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    public T[] getAll() {
        // This method is not defined in the QueueInterface, so we can return an empty array
        return (T[]) new Object[0]; // Return an empty array of type T
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString().trim();
    }

    /**
     * Returns a string representation of the queue.
     * This method iterates through the queue and appends each element to a StringBuilder.
     * @return A string containing all elements in the queue, separated by spaces.
     */
    public String display() { // is this method necessary?
        StringBuilder sb = new StringBuilder();
        Node currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString().trim();
    }
}
