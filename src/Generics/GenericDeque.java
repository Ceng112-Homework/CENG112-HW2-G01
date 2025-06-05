package Generics;

import Interfaces.DequeInterface;
import Interfaces.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Generic Deque class implementing DequeInterface
public class GenericDeque<T> implements DequeInterface<T> {

    // Using a ListInterface to store the elements of the deque
    private final ListInterface<T> deque;

    // Constructor initializes the deque using a LinkedList
    public GenericDeque() {
        deque = new LinkedList<>();
    }

    // Method to get first element (front) of the deque
    public T getFront() {
        return deque.getEntry(1);
    }

    // Method to get last element (back) of the deque
    public T getBack() {
        int length = deque.getLength();
        return deque.getEntry(length);
    }

    // Method to add an element to the front of the deque
    public void addFront(T newEntry) {
        deque.add(1, newEntry);
    }

    // Method to add an element to the back of the deque
    public void addBack(T newEntry){
        deque.add(newEntry);
    }

    // Method to remove and return the front element of the deque
    public T removeFront() {
        return deque.remove(1);
    }

    // Method to remove and return the back element of the deque
    public T removeBack() {
        int length = deque.getLength();
        return deque.remove(length);
    }

    // Method to get the size of the deque
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(deque.toArray()));
        return list;
    }

    // Method to check if the deque is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Method to clear the deque
    public void clear() {
        deque.clear();
    }

    // Method to display the elements of the deque as a string
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
