package Generics;

import Interfaces.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Generic history class that can store any type of action
public class GenericHistory<T> {

    // Using a linked list to store the history of actions
    private final ListInterface<T> history; // Queue is a linked list

    // Constructor initializes the history list
    public GenericHistory () {
        history = new LinkedList<>();
    }

    // Method to add an action to the history
    public void add(T action) {
        history.add(action);
    }

    // Method to get all actions in the history in a list
    public List<T> getAll() {
        return new ArrayList<>(Arrays.asList(history.toArray()));
    }

    // Method to print all actions in the history
    public void display() {
        Object[] arr = history.toArray();
        for (Object obj: arr) {
            System.out.println(obj.toString());
        }
    }




}
