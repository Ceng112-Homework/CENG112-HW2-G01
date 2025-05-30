import Generics.GenericDeque;
import Models.Command;
import Services.FileIO;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello from the Main class!");

        FileIO reader = new FileIO();
        // Example usage of FileIO
        String filePath = "commands.txt"; // Example file path
        reader.readFile(filePath);

        // You can also write or append to a file
        String content = "Sample content to write to file.";
        reader.writeFile(filePath, content);
        reader.appendToFile(filePath, "Appending this content to the file.");


        // Further processing can be done here, such as initializing the queue or priority queue
        // and processing commands from the file.
        System.out.println("File operations completed.");
        // You can also initialize the CommandProcessor and process commands
        // CommandProcessor commandProcessor = new CommandProcessor();
        // commandProcessor.processCommand("new"); // command to create a new ticket
        // commandProcessor.processCommand("resolve"); // resolve the next ticket
        // commandProcessor.processCommand("display"); // display current tickets
        // commandProcessor.processCommand("history"); // show resolved tickets history

        // Further logic can be added to handle user input and manage the ticketing system.
        System.out.println("Ticketing system initialized and ready to process commands.");
        // You can also initialize the queue or priority queue here
        // and start processing commands from the user or file.

        // For example, you can create a queue to manage tickets
        GenericDeque<Command> ticketQueue = new GenericDeque<>();
        ticketQueue.addToBack(new Command("new", "Customer1", "Ticket1", "Issue1"));
        ticketQueue.addToBack(new Command("new", "Customer2", "Ticket2", "Issue2"));
        System.out.println("Tickets in queue: " + ticketQueue.display());
        // You can also resolve tickets from the queue
        Command resolvedTicket = ticketQueue.removeFront();
        System.out.println("Resolved ticket: " + resolvedTicket.getName());
        // Display remaining tickets in the queue
        System.out.println("Remaining tickets in queue: " + ticketQueue.display());
        // You can also clear the queue if needed
        ticketQueue.clear();
        System.out.println("Main method execution completed.");

    }
}