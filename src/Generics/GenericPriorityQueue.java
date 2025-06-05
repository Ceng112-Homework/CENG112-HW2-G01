package Generics;

import Interfaces.HasPriority;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericPriorityQueue<T extends Comparable<T> & HasPriority> {
    private final QueueInterface<T> low;
    private final QueueInterface<T> medium;
    private final QueueInterface<T> high;
    private final QueueInterface<T> chronological;

    public GenericPriorityQueue() {
        low = new GenericQueue<>();
        medium = new GenericQueue<>();
        high= new GenericQueue<>();
        chronological = new GenericQueue<>();
    }

    public boolean offer(T item) {
        int priorityValue = item.getPriorityValue();
       boolean added = false;
        if (priorityValue == 3) {
            high.enqueue(item);
            added = true;
        }
        else if (priorityValue == 2) {
            medium.enqueue(item);
            added = true;
        }
        else if (priorityValue == 1) {
            low.enqueue(item);
            added = true;
        }
        chronological.enqueue(item);
        return added;
    }

    public T poll() {
        T item = null;

        if (!high.isEmpty()) {
            item = high.dequeue();
        }
        else if (!medium.isEmpty()) {
            item = medium.dequeue();
        }
        else if (!low.isEmpty()) {
            item = low.dequeue();
        }

        return item;
    }

    public List<T> getChronological(boolean reverse) {
        if (reverse) {
            List<T> reversedList = new ArrayList<>(chronological.getAll());
            Collections.reverse(reversedList);
            return reversedList;
        } else {
            return chronological.getAll();
        }
    }

    public boolean isEmpty() {
        // Check if all queues are empty
        return (low.isEmpty() && medium.isEmpty() && high.isEmpty());
    }

    public List<T> getAll() {
        List<T> allItems = new ArrayList<>();

        List<T> highArr = high.getAll();
        List<T> medArr = medium.getAll();
        List<T> lowArr = low.getAll();

        allItems.addAll(highArr);
        allItems.addAll(medArr);
        allItems.addAll(lowArr);
        return allItems;
    }
}
