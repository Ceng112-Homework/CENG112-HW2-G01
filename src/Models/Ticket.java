package Models;

import java.util.Date;
import Interfaces.HasPriority;

// Ticket class representing a support ticket with
// customer name, issue description, priority, and arrival time.
public class Ticket implements Comparable<Ticket>, HasPriority {

    // Fields for the Ticket class
    String customerName;
    String issueDescription;
    String priority;
    Date arrivalTime;

    // Constructor to initialize a Ticket object
    public Ticket(String customerName, String issueDescription, String priority, Date arrivalTime) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    // Getters and setters for the Ticket class
    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    // method to ticket to string
    public String toString() {
        return customerName + " - " + issueDescription + " [" + priority + " Priority]";
    }

    // Method to compare this ticket with another ticket based on priority and arrival time
    public int compareTo(Ticket otherTicket) {
        int thisPriority = this.getPriorityValue();
        int otherPriority = otherTicket.getPriorityValue();

        // Compare priorities first, then arrival times
        if (thisPriority != otherPriority)
            return otherPriority - thisPriority; // High > Medium > Low
        else
            return this.arrivalTime.compareTo(otherTicket.arrivalTime);
    }

    // Method to get the priority value for comparison
    public int getPriorityValue() {
        int value = 0;

        // switch statement to assign priority values
        switch (priority.toLowerCase()) {
            case "high" -> value = 3;
            case "medium" -> value = 2;
            case "low" -> value = 1;
        }
        return value;
    }
}
