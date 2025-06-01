package Generics;

import Interfaces.HasPriority;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericPriorityQueue<T extends Comparable<T> & HasPriority> {
    // Three different queues for low, medium and high priority items
    private final QueueInterface<T> low;
    private final QueueInterface<T> medium;
    private final QueueInterface<T> high;

    public GenericPriorityQueue() {
        low = new GenericQueue<>();
        medium = new GenericQueue<>();
        high= new GenericQueue<>();
    }

    /**
     * Add an item to the priority queue.
     * @param item item to be added.
     * @return true if the item is added, false otherwise
     */
    public boolean offer(T item) {
        int priorityValue = item.getPriorityValue();
        // priorityValue = 3 -> High priority
        // priorityValue = 2 -> Medium priority
        // priorityValue = 1 -> Low priority
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
        return added;
    }

    /**
     * Removes and return the item with the greatest priority.
     * @return The item with the greatest priority.
     */
    public T poll() {
        T item = null;
        // Check items in decreasing order of priority.
        if (!high.isEmpty()) {
            item = high.dequeue();
        }
        else if (!medium.isEmpty()) {
            item = medium.dequeue();
        }
        else if (!low.isEmpty()) {
            item = low.dequeue();
        }
        // All queues are empty, return null
        return item;
    }

    /**
     * Check if the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() {
        // Check if all queues are empty
        return (low.isEmpty() && medium.isEmpty() && high.isEmpty());
    }

    /**
     * Returns an array with all the items in the priority queue.
     * @return
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        // Note: I needed to do google searches to figure out how to implement getAll methods.
        // An arraylist to hold all items in high, medium and low queues.
        List<T> allItems = new ArrayList<>();

        T[] highArr = high.getAll();
        T[] medArr = medium.getAll();
        T[] lowArr = low.getAll();

        // Add all items of three queues to allItems.
        Collections.addAll(allItems, highArr);
        Collections.addAll(allItems, medArr);
        Collections.addAll(allItems, lowArr);

        // Use the first non-empty array to determine component type
        T[] sampleArray = highArr.length > 0 ? highArr : (medArr.length > 0 ? medArr : lowArr);

        // Create a generic array using reflection
        // java.lang.reflect.Array.newInstance(componentType, length)
        // componentType example: Ticket.class
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                sampleArray.getClass().getComponentType(),
                allItems.size()
        );

        return allItems.toArray(result);
    }
}
