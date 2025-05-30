package Interfaces;

public interface DequeInterface<T> {
    void addToFront(T item);
    void addToBack(T item);
    T removeFront();
    T removeBack();
    T[] getAll(); // I don't know what should this method returns.
    boolean isEmpty();
    void clear();
    String display();
}
