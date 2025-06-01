package Models;

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

    /**
     * Compare the ticket with another ticket.
     * If their priorities are the same, it compares by the arrival times.
     * -1 => This ticket has more priority
     *  1 => This ticket has less priority
     * @param otherTicket the object to be compared.
     * @return the comparison result
     */
    @Override
    public int compareTo(Ticket otherTicket) {
        int thisPriority = this.getPriorityValue();
        int otherPriority = otherTicket.getPriorityValue();
        if (thisPriority != otherPriority)
            return otherPriority - thisPriority; // High > Medium > Low
        else
            return this.arrivalTime.compareTo(otherTicket.arrivalTime);
    }

    /**
     * get the priority value of the ticket
     * 3 -> high
     * 2 -> medium
     * 1 -> low
     * @return the priority value
     */
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
