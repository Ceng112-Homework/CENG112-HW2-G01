package Interfaces;

public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    T getFront();
    boolean isEmpty();
    void clear();
    T[] getAll();
}
