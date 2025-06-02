package Generics;

import Interfaces.ListInterface;

public class GenericHistory<T> {
    private final ListInterface<T> history; // Queue is a linked list

    public GenericHistory () {
        history = new LinkedList<>();
    }

    public void add(T action) {
        history.add(action);
    }

    public T[] getAll() {
        return history.toArray();
    }

    public void display() {
        Object[] arr = history.toArray();
        for (Object obj: arr) {
            System.out.println(obj.toString());
        }
    }




}
