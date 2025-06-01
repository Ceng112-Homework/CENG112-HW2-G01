package Generics;

import Interfaces.HasPriority;
import Interfaces.PriorityQueueInterface;
import Interfaces.QueueInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericPriorityQueue<T extends Comparable<T> & HasPriority> {
    // Three different queues for low, medium and high priority items
    private QueueInterface<T> low;
    private QueueInterface<T> medium;
    private QueueInterface<T> high;

    public GenericPriorityQueue() {
        low = new GenericQueue<>();
        medium = new GenericQueue<>();
        high= new GenericQueue<>();
    }

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

    public boolean isEmpty() {
        // Check if all queues are empty
        return (low.isEmpty() && medium.isEmpty() && high.isEmpty());
    }

    @SuppressWarnings("unchecked")
    public T[] getAll() {
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
        // Needed to google search for the method.
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                sampleArray.getClass().getComponentType(),
                allItems.size()
        );

        return allItems.toArray(result);

    }
}
