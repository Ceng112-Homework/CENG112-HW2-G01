import Models.Command;
import Services.CommandProcessor;
import Services.FileIO;

import java.util.List;

// Main class to run the command processing application
public class Main{
    public static void main(String[] args) throws Exception{

        // Initialize the FileIO and CommandProcessor services
        FileIO reader = new FileIO();
        CommandProcessor processor = new CommandProcessor();

        // Read commands from a file and process them
        String filePath = "Files/example_commands.csv"; // Example file path

        // Read the commands from the specified file
        List<Command> lines = reader.readFile(filePath);

        // Process each command using the CommandProcessor
        for (Command command : lines) {
            processor.processCommand(command);
        }

    }
}