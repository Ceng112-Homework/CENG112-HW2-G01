package Models;

import Interfaces.HasPriority;

import java.util.Date;
import Interfaces.HasPriority;

public class Ticket implements Comparable<Ticket>, HasPriority {
    String customerName;
    String issueDescription;
    String priority;
    Date arrivalTime;

    public Ticket(String customerName, String issueDescription, String priority, Date arrivalTime) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customerName='" + customerName + "'" +
                ", issueDescription='" + issueDescription + "'" +
                ", priority='" + priority + "'" +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        int thisPriority = this.getPriorityValue();
        int otherPriority = o.getPriorityValue();
        if (thisPriority != otherPriority)
            return otherPriority - thisPriority; // High > Medium > Low
        else
            return this.arrivalTime.compareTo(o.arrivalTime);
    }

    @Override
    public int getPriorityValue() {
        int value = 0;
        switch (priority.toLowerCase()) {
            case "high" -> value = 3;
            case "medium" -> value = 2;
            case "low" -> value = 1;
        }
        return value;

    }
}
