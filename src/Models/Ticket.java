package Models;

import java.util.Date;

public class Ticket {
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
        return "Ticket:" +
                "customerName='" + customerName + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", arrivalTime=" + arrivalTime + '\'';
    }
}
