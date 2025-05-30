package Interfaces;

public interface PriorityQueueInterface<T> {
    T offer(T item);
    T poll();
    boolean isEmpty();
    T[] getAll(); // I don't know what should this method returns.

}
