package Models;

import java.util.List;

// Command class represents a command with a type and a list of arguments.
// The type is case-insensitive and is stored in lowercase.
public class Command {

    // Attributes
    private final String type; // e.g., new, resolve, display, history
    private final List<String> arguments;

    // Constructor for Command
    public Command(String type, List<String> arguments) {
        this.type = type.toLowerCase();
        this.arguments = arguments;
    }

    // Getters
    public String getType() {
        return type;
    }

    public List<String> getArguments() {
        return arguments;
    }

    // Method to get an argument by its index
    public String getArgument(int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= arguments.size())
            return null;
        return arguments.get(index);
    }

    // Method for convert command to string
    public String toString() {
        return "Command{" +
                "type='" + type + '\'' +
                ", arguments=" + arguments + '}';
    }

}
