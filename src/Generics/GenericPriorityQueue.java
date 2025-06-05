package Generics;

import Interfaces.HasPriority;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// GenericPriorityQueue class that implements a priority queue
public class GenericPriorityQueue<T extends Comparable<T> & HasPriority> {
    // Three separate queues for different priority levels
    private final QueueInterface<T> low;
    private final QueueInterface<T> medium;
    private final QueueInterface<T> high;

    // A chronological queue to maintain the order of insertion
    private final QueueInterface<T> chronological;

    // Constructor initializes the three priority queues and the chronological queue
    public GenericPriorityQueue() {
        low = new GenericQueue<>();
        medium = new GenericQueue<>();
        high= new GenericQueue<>();
        chronological = new GenericQueue<>();
    }

    // Method to add an item to the priority queue based on its priority value
    public boolean offer(T item) {
        // get the priority value from the item
        int priorityValue = item.getPriorityValue();

        // flag to check if the item be added
        boolean added = false;

        // Check the priority value and enqueue the item in the appropriate queue
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

        // Regardless of priority, add the item to the chronological queue
        if (added)
            chronological.enqueue(item);

        // Return true the item was successfully added
        return added;
    }

    // Method to retrieve and remove the item with the highest priority
    public T poll() {
        T item = null;

        // Check the high priority queue first, then medium, and finally low
        // for ensure the highest priority item is returned
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

    // Method to retrieve all items in the chronological order
    public List<T> getChronological(boolean reverse) {
        // If reverse is true, return the items in reverse order
        if (reverse) {
            List<T> reversedList = new ArrayList<>(chronological.getAll());
            Collections.reverse(reversedList);
            return reversedList;
        } else {
            return chronological.getAll();
        }
    }

    // Method to control the query is empty or not
    public boolean isEmpty() {
        // Check if all queues are empty
        return (low.isEmpty() && medium.isEmpty() && high.isEmpty());
    }

    // Method to get all items in the priority queue
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
