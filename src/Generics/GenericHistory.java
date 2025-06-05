package Generics;

import Interfaces.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericHistory<T> {
    private final ListInterface<T> history; // Queue is a linked list

    public GenericHistory () {
        history = new LinkedList<>();
    }

    public void add(T action) {
        history.add(action);
    }

    public List<T> getAll() {
        return new ArrayList<>(Arrays.asList(history.toArray()));
    }

    public void display() {
        Object[] arr = history.toArray();
        for (Object obj: arr) {
            System.out.println(obj.toString());
        }
    }




}
