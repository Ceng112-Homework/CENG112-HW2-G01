package Interfaces;

// This interface defines the basic operations for a list data structure.
public interface ListInterface<T> {
    void add (T newEntry);

    boolean add (int newPosition, T newEntry);

    T remove(int givenPosition);

    void clear();

    boolean replace(int givenPosition, T newEntry);

    T getEntry(int givenPosition);

    boolean contains(T anEntry);

    int getLength();

    boolean isEmpty();

    T[] toArray();
}
