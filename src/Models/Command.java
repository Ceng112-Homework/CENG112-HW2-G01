package Models;

import java.util.List;

public class Command {
    private String type; // e.g., new, resolve, display, history
    private List<String> arguments;

    public Command(String type, List<String> arguments) {
        this.type = type.toLowerCase();
        this.arguments = arguments;
    }

    public String getType() {
        return type;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public String getArgument(int index) {
        if (index < 0 || index >= arguments.size())
            return null;
        return arguments.get(index);            
    }

    @Override
    public String toString() {
        return "Command{" +
                "type='" + type + '\'' +
                ", arguments=" + arguments + '}';
    }

}
