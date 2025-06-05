package Services;

import Models.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {

    public List<Command> readFile(String filePath) throws Exception{

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            boolean newLine = true;
            while (newLine) {
                newLine = false;
                String line = reader.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    lines.add(line);
                    newLine = true;
                }
            }
            System.out.println("Read " + lines.size() + " lines from file: " + filePath + "\n");

            for (String commandLine : lines) {
                Command command;
                List<String> parts = new ArrayList<>(Arrays.asList(commandLine.split(",")));
                command = new Command(parts.getFirst(), parts.subList(1, parts.size()));
                commands.add(command);
            }

            return commands;
        } catch (Exception e) {
            throw new Exception("Error reading file: " + e.getMessage());
        }
    }
}
