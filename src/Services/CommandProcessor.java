package Services;

import Generics.GenericHistory;
import Generics.GenericPriorityQueue;
import Models.Command;
import Models.Ticket;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CommandProcessor {
    private final GenericPriorityQueue<Ticket> ticketQueue;
    private final GenericHistory<Ticket> history;

    public CommandProcessor() {
        ticketQueue = new GenericPriorityQueue<>();
        history = new GenericHistory<>();
    }

    public void processCommand(Command command) throws Exception{
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
        Ticket resolvedTicket = ticketQueue.poll();
        System.out.println("\nResolving Ticket:\n" + "Resolved:" + resolvedTicket);
        history.add(resolvedTicket);
    }

    private void displayTickets(String order) throws Exception {
        List<Ticket> ticketList = ticketQueue.getAll();

        if (order == null) {
            throw new Exception("\nOrder cannot be null. Please specify an order.");
        }
        else if (order.equalsIgnoreCase("priority")) {
            System.out.println("\n--- Displaying Active Tickets (By Priority) ---");
            ticketList.sort((t1, t2) -> t1.compareTo(t2));
        }
        else if (order.equalsIgnoreCase("asc")) {
            System.out.println("\n--- Displaying Active Tickets (ASC - Oldest First) ---");
            ticketList = ticketQueue.getChronological(false);

        }
        else if (order.equalsIgnoreCase("desc")) {
            System.out.println("\n--- Displaying Active Tickets (DESC - Newest First) ---");
            ticketList = ticketQueue.getChronological(true);
        }
        for (Ticket ticket: ticketList) {
            System.out.println(ticket);
        }
    }

    private void displayHistory(String order) {
        List<Ticket> ticketHistory = history.getAll();

        if (order == null) {
            System.out.println("\n--- Resolved Ticket History (Sorted by Customer Name) ---");
            ticketHistory.sort((t1, t2) -> t1.getCustomerName().compareTo(t2.getCustomerName()));
        }
        else if (order.equalsIgnoreCase("asc")) {
            System.out.println("\n--- Resolved Ticket History (ASC - Oldest First) ---");
        }
        else if (order.equalsIgnoreCase("desc")) {
            System.out.println("\n--- Resolved Ticket History (DESC - Newest First) ---");
            Collections.reverse(ticketHistory);
        }

        for (Ticket ticket: ticketHistory) {
            System.out.println(ticket);
        }
    }
}
