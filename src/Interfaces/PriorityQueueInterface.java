package Interfaces;

import java.util.List;

// This interface defines the basic operations for a priority queue data structure.
public interface PriorityQueueInterface<T> {
    T offer(T item);
    T poll();
    boolean isEmpty();
    List<T> getAll();
}
