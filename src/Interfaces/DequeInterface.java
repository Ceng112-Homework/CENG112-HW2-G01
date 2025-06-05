package Interfaces;

import java.util.List;

// This interface defines the basic operations for a deque (double-ended queue) data structure.
public interface DequeInterface<T> {
    void addFront(T item);
    void addBack(T item);
    T removeFront();
    T removeBack();
    boolean isEmpty();
    void clear();
    String display();
    List<T> getAll();
}
