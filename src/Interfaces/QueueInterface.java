package Interfaces;

import java.util.List;

// This interface defines the basic operations for a queue data structure.
public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    T getFront();
    boolean isEmpty();
    void clear();
    List<T> getAll();
}
