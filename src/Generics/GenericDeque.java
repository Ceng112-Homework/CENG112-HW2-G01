package Generics;

import Interfaces.DequeInterface;

public class GenericDeque<T> implements DequeInterface<T> {
    private DLNode firstNode;
    private DLNode lastNode;

    public GenericDeque() {
        firstNode = null;
        lastNode = null;
    }

    public class DLNode {
        private T data;
        private DLNode next;
        private DLNode previous;

        public DLNode(DLNode previous, T data, DLNode next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public DLNode getNextNode() {
            return next;
        }

        public void setNextNode(DLNode next) {
            this.next = next;
        }

        public DLNode getPreviousNode() {
            return previous;
        }

        public void setPreviousNode(DLNode previous) {
            this.previous = previous;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public T getFront() {
        if (isEmpty()) {
            /*throw new Exception("Queue is empty");*/
            return null; // Return null if the queue is empty
        } else {
            return firstNode.getData();
        }
    }

    public T getBack() {
        if (isEmpty()) {
            /*throw new Exception("Queue is empty");*/
            return null; // Return null if the queue is empty
        } else {
            return lastNode.getData();
        }
    }

    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry, firstNode);
        if (isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;

    }

    public void addToBack(T newEntry){
        DLNode newNode = new DLNode(lastNode, newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    public T removeFront() {
        T front = getFront();
        assert firstNode != null;
        firstNode = firstNode.getNextNode();
        if (firstNode != null) {
            firstNode.setPreviousNode(null);
        } else {
            lastNode = null; // If the deque is now empty, set lastNode to null
        }
        return front;
    }

    public T removeBack() {
        T back = getBack();
        assert lastNode != null;
        lastNode = lastNode.getPreviousNode();

        if (lastNode != null) {
            lastNode.setNextNode(null);
        } else {
            firstNode = null; // If the deque is now empty, set firstNode to null
        }
        return back;
    }

    public T[] getAll() {
        // This method should return an array of all elements in the deque.
        // However, the implementation is not provided here.
        // You can implement it based on your requirements.
        return null; // Placeholder return statement
    }

    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        DLNode currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString().trim(); // Return the string representation of the deque
    }
}
