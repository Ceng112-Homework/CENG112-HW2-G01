package Services;

import Models.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// File IO class to read commands from a file
public class FileIO {

    // Reads commands from a file and returns a list of Command objects
    public List<Command> readFile(String filePath) throws Exception{

        // List to hold lines read from the file and commands created from those lines
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();

        // Read the file line by line with BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            boolean newLine = true;

            // Read lines until the end of the file
            while (newLine) {
                newLine = false;
                String line = reader.readLine();
                // If the line is not null and not empty, add it to the list
                if (line != null && !line.trim().isEmpty()) {
                    lines.add(line);
                    newLine = true;
                }
            }
            // Print the number of lines read from the file
            System.out.println("Read " + lines.size() + " lines from file: " + filePath + "\n");

            // Process each line to create Command objects
            for (String commandLine : lines) {
                Command command; // command object to hold the command and its arguments

                // Split the line by commas to separate command and its arguments
                List<String> parts = new ArrayList<>(Arrays.asList(commandLine.split(",")));

                // add command to the list of commands
                command = new Command(parts.getFirst(), parts.subList(1, parts.size()));
                commands.add(command);
            }

            return commands; // return the list of Command objects
        } catch (Exception e) {
            // Handle exceptions that may occur while reading the file
            throw new Exception("Error reading file: " + e.getMessage());
        }
    }
}
