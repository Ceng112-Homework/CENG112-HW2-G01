package Generics;

import Interfaces.DequeInterface;

public class GenericDeque<T> implements DequeInterface<T> {
    private DLNode firstNode;
    private DLNode lastNode;
    private int numberOfItems;

    public GenericDeque() {
        clear();
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

    public void addFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry, firstNode);
        if (isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
        numberOfItems++;
    }

    public void addBack(T newEntry){
        DLNode newNode = new DLNode(lastNode, newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        numberOfItems++;
    }

    public T removeFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNextNode();
            if (firstNode == null)
                lastNode = null;
            else
                firstNode.setPreviousNode(null);
            numberOfItems--;
        }
        return front;
    }

    public T removeBack() {
        T back = null;
        if (!isEmpty()) {
            back = lastNode.getData();
            lastNode = lastNode.getPreviousNode();
            if (lastNode == null)
                firstNode = null;
            else
                lastNode.setNextNode(null);
            numberOfItems--;
        }
        return back;
    }

    @SuppressWarnings("unchecked")
    public T[] getAll() {
        T[] items = (T[]) new Object[numberOfItems];
        DLNode currentNode = firstNode;
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = currentNode.getData();
            currentNode = currentNode.getNextNode();
        }
        return items;
    }

    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfItems = 0;
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

    private class DLNode {
        private final T data;
        private DLNode next;
        private DLNode previous;

        DLNode(DLNode previous, T data, DLNode next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        DLNode getNextNode() {
            return next;
        }

        void setNextNode(DLNode next) {
            this.next = next;
        }

        DLNode getPreviousNode() {
            return previous;
        }

        void setPreviousNode(DLNode previous) {
            this.previous = previous;
        }

        T getData() {
            return data;
        }
    }
}
