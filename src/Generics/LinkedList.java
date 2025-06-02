package Generics;

import Interfaces.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode; // head reference to first node
    private Node lastNode; // tail reference to last node
    private int numberOfEntries; // number of entries in the list

    public LinkedList() {
        clear();
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
        numberOfEntries++;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
            }
            else if (newPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else if (newPosition == numberOfEntries + 1) {
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            }
            else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
        }
        else
            isSuccessful = false;

        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if (givenPosition == 1) {
                result = firstNode.getData(); // save entry to be removed
                firstNode = firstNode.getNextNode();
                if (numberOfEntries == 1) {
                    lastNode = null;
                }
            }
            else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = nodeToRemove.getData(); // save entry to be removed
                if (givenPosition == numberOfEntries) { // last node was removed
                    lastNode = nodeBefore;
                }
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
        }
        else
            isSuccessful = false;
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            result = getNodeAt(givenPosition).getData();
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (currentNode.getData().equals(anEntry)) {
                found = true;
            }
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
            assert firstNode == null;
            result = true;
        }
        else {
            assert firstNode != null;
            result = false;
        }
        return result;
    }

    @Override
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    // 1 <= givenPosition <= numberOfNodes
    private Node getNodeAt(int givenPosition) {
        assert (firstNode != null) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;

        // traverse the chain to locate the desired node
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.getNextNode();
        }
        assert currentNode != null;

        return currentNode;
    }

    private class Node {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
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
