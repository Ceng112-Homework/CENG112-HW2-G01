package Services;

import Generics.GenericHistory;
import Generics.GenericPriorityQueue;
import Models.Command;
import Models.Ticket;

import java.util.Collections;
import java.util.Date;
import java.util.List;

// CommandProcessor class processes commands related to ticket management.
public class CommandProcessor {

    // GenericPriorityQueue is used to manage active tickets based on priority.
    private final GenericPriorityQueue<Ticket> ticketQueue;

    // GenericHistory is used to maintain a history of resolved tickets.
    private final GenericHistory<Ticket> history;

    // Constructor initializes the ticket queue and history.
    public CommandProcessor() {
        ticketQueue = new GenericPriorityQueue<>();
        history = new GenericHistory<>();
    }

    // Processes a command based on its type.
    public void processCommand(Command command) throws Exception{
        String commandType = command.getType().toLowerCase(); // get the command type in lowercase
        switch (commandType) {
            case "new": // if type= "new", create a new ticket
                String customerName = command.getArgument(0);
                String issueDescription = command.getArgument(1);
                String priority = command.getArgument(2);
                Ticket ticket = new Ticket(customerName, issueDescription, priority, new Date());
                addTicket(ticket);
                break;
            case "resolve": // if type= "resolve", resolve the ticket
                resolveTicket();
                break;
            case "display": // if type= "display", display active tickets
                displayTickets(command.getArgument(0));
                break;
            case "history": // if type= "history", display resolved tickets
                displayHistory(command.getArgument(0));
                break;
            default: // if type didn't handled, print an error message
                System.out.println("Unknown command: " + command);
        }
    }

    // method for adding a ticket to the queue
    private void addTicket(Ticket ticket) {
        System.out.println("Adding ticket: " + ticket);
        ticketQueue.offer(ticket);
    }

    // method for resolving a ticket from the queue
    private void resolveTicket() {
        Ticket resolvedTicket = ticketQueue.poll();
        System.out.println("\nResolving Ticket:\n" + "Resolved:" + resolvedTicket);
        history.add(resolvedTicket);
    }

    // method for displaying tickets based on the specified order
    private void displayTickets(String order) throws Exception {
        // get all active tickets to temporarily store them
        List<Ticket> ticketList = ticketQueue.getAll();

        if (order == null) {
            throw new Exception("\nOrder cannot be null. Please specify an order.");
        }
        else if (order.equalsIgnoreCase("priority")) {
            System.out.println("\n--- Displaying Active Tickets (By Priority) ---");
            // sort tickets by priority
            ticketList.sort((t1, t2) -> t1.compareTo(t2));
        }
        else if (order.equalsIgnoreCase("asc")) {
            System.out.println("\n--- Displaying Active Tickets (ASC - Oldest First) ---");
            // sort tickets by creation date in ascending order
            ticketList = ticketQueue.getChronological(false);

        }
        else if (order.equalsIgnoreCase("desc")) {
            System.out.println("\n--- Displaying Active Tickets (DESC - Newest First) ---");
            // sort tickets by creation date in descending order
            ticketList = ticketQueue.getChronological(true);
        } else {
            throw new Exception("Invalid order specified. Use 'priority', 'asc', or 'desc'.");
        }

        // print each active ticket in the specified order
        for (Ticket ticket: ticketList) {
            System.out.println(ticket);
        }
    }

    // method for displaying the history of resolved tickets
    private void displayHistory(String order) {
        // get all resolved tickets to temporarily store them
        List<Ticket> ticketHistory = history.getAll();

        if (order == null) {
            System.out.println("\n--- Resolved Ticket History (Sorted by Customer Name) ---");
            // sort tickets by customer name
            ticketHistory.sort((t1, t2) -> t1.getCustomerName().compareTo(t2.getCustomerName()));
        }
        else if (order.equalsIgnoreCase("asc")) {
            // sort tickets by creation date in ascending order
            System.out.println("\n--- Resolved Ticket History (ASC - Oldest First) ---");
        }
        else if (order.equalsIgnoreCase("desc")) {
            // sort tickets by creation date in descending order
            System.out.println("\n--- Resolved Ticket History (DESC - Newest First) ---");
            Collections.reverse(ticketHistory);
        } else {
            System.out.println("Invalid order specified. Use 'asc' or 'desc'.");
        }

        // print each resolved ticket in the specified order
        for (Ticket ticket: ticketHistory) {
            System.out.println(ticket);
        }
    }
}
