package Interfaces;

import java.util.List;

public interface PriorityQueueInterface<T> {
    T offer(T item);
    T poll();
    boolean isEmpty();
    List<T> getAll();
}
