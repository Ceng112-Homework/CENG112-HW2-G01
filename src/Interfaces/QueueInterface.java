package Interfaces;

import java.util.List;

public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    T getFront();
    boolean isEmpty();
    void clear();
    List<T> getAll();
}
