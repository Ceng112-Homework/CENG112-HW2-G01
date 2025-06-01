package Interfaces;

public interface DequeInterface<T> {
    void addFront(T item);
    void addBack(T item);
    T removeFront();
    T removeBack();
    boolean isEmpty();
    void clear();
    String display();
    T[] getAll();
}
