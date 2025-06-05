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

    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return customerName + " - " + issueDescription + " [" + priority + " Priority]";
    }


    @Override
    public int compareTo(Ticket otherTicket) {
        int thisPriority = this.getPriorityValue();
        int otherPriority = otherTicket.getPriorityValue();
        if (thisPriority != otherPriority)
            return otherPriority - thisPriority; // High > Medium > Low
        else
            return this.arrivalTime.compareTo(otherTicket.arrivalTime);
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
