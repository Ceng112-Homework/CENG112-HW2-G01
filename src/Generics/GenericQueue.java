package Generics;

import Interfaces.ListInterface;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericQueue<T> implements QueueInterface<T> {

    private final ListInterface<T> queue;

    public GenericQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T newEntry) {
        queue.add(newEntry);
    }

    public T dequeue() {
        return queue.remove(1);
    }

    public T getFront() {
        return queue.getEntry(1);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public List<T> getAll() {
        return new ArrayList<>(Arrays.asList(queue.toArray()));
    }

    public void clear() {
        queue.clear();
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        Object[] arr = queue.toArray();
        for (Object obj: arr) {
            String str = obj.toString();
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}
