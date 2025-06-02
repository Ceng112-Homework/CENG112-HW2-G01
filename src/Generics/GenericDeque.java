package Generics;

import Interfaces.DequeInterface;
import Interfaces.ListInterface;

public class GenericDeque<T> implements DequeInterface<T> {

    private final ListInterface<T> deque;

    public GenericDeque() {
        deque = new LinkedList<>();
    }

    public T getFront() {
        return deque.getEntry(1);
    }

    public T getBack() {
        int length = deque.getLength();
        return deque.getEntry(length);
    }

    public void addFront(T newEntry) {
        deque.add(1, newEntry);
    }

    public void addBack(T newEntry){
        deque.add(newEntry);
    }

    public T removeFront() {
        return deque.remove(1);
    }

    public T removeBack() {
        int length = deque.getLength();
        return deque.remove(length);
    }

    public T[] getAll() {
        return deque.toArray();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void clear() {
        deque.clear();
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        Object[] arr = deque.toArray();
        for (Object obj : arr) {
            String str = (String) obj;
            sb.append(str).append(" ");
        }
        return sb.toString().trim(); // Return the string representation of the deque
    }
}
