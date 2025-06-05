import Models.Command;
import Services.CommandProcessor;
import Services.FileIO;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception{

        FileIO reader = new FileIO();
        CommandProcessor processor = new CommandProcessor();

        String filePath = "Files/example_commands.csv"; // Example file path
        List<Command> lines = reader.readFile(filePath);
        for (Command command : lines) {
            processor.processCommand(command);

        }



    }
}