package Services;

import Generics.GenericHistory;
import Generics.GenericPriorityQueue;
import Interfaces.ListInterface;
import Interfaces.PriorityQueueInterface;
import Models.Command;
import Models.Ticket;

import java.util.Date;
import java.util.List;

public class CommandProcessor {
    // This class will process commands from the user.
    private final GenericPriorityQueue<Ticket> ticketQueue;
    private final GenericHistory<Ticket> history;

    public CommandProcessor() {
        ticketQueue = new GenericPriorityQueue<>();
        history = new GenericHistory<>();
    }

    public void processCommand(Command command) {
        // Parse the command and execute the appropriate action
        // For example, if the command is "new", create a new ticket
        // If the command is "resolve", resolve the next ticket in the queue
        // If the command is "display", show all tickets in the queue
        // If the command is "history", show resolved tickets history
        String commandType = command.getType().toLowerCase();
        switch (commandType) {
            case "new":
                String customerName = command.getArgument(0);
                String issueDescription = command.getArgument(1);
                String priority = command.getArgument(2);
                Ticket ticket = new Ticket(customerName, issueDescription, priority, new Date());
                addTicket(ticket);
                break;
            case "resolve":
                resolveTicket();
                break;
            case "display":
                displayTickets(command.getArgument(0));
                break;
            case "history":
                displayHistory(command.getArgument(0));
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }

    private void addTicket(Ticket ticket) {
        System.out.println("Adding ticket: " + ticket);
        ticketQueue.offer(ticket);
    }

    private void resolveTicket() {
        System.out.println("Resolving Ticket:");
        Ticket resolvedTicket = ticketQueue.poll();
        history.add(resolvedTicket);
        System.out.println("Resolved: " + resolvedTicket);
    }

    private void displayTickets(String order) {
        if (order == null) {
            // logic will be implemented
        }
        if (order.toLowerCase().equals("priority")) {
            System.out.println("--- Displaying Active Tickets (By Priority) ---");
            // logic will be implemented
        }
        if (order.toLowerCase().equals("asc")) {
            System.out.println("--- Displaying Active Tickets (By ASC - Oldest First) ---");
            // logic will be implemented
        }
        if (order.toLowerCase().equals("desc")) {
            System.out.println("--- Displaying Active Tickets (By DESC - Newest First) ---");
            // logic will be implemented
        }
        Object[] ticketObjects =  ticketQueue.getAll();
        for (Object ticketObj: ticketObjects) {
            System.out.println(ticketObj);
        }
    }

    private void displayHistory(String order) {
        if (order == null) {
            // logic will be implemented
        }
        if (order.toLowerCase().equals("asc")) {
            System.out.println("--- Displaying Active Tickets (By ASC - Oldest First) ---");
            // logic will be implemented
        }
        if (order.toLowerCase().equals("desc")) {
            System.out.println("--- Displaying Active Tickets (By DESC - Newest First) ---");
            // logic will be implemented
        }

        Object[] resolvedTickets =  history.getAll();
        for (Object ticketObj: resolvedTickets) {
            System.out.println(ticketObj);
        }
    }
}
