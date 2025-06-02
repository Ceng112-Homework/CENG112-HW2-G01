package Services;

import Models.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileIO {

    public ArrayList<Command> readFile(String filePath) {

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            boolean lastLine = true;
            while (lastLine) {
                lastLine = false;
                String line = reader.readLine();
                System.out.println(line);
                if (line != null && !line.trim().isEmpty()) {
                    lines.add(line);
                    lastLine = true;
                }
            }
            for (String commandLine : lines) {
                Command command;
                String[] parts = commandLine.split(",");
                switch (parts.length) {
                    case 1:
                        command = new Command(parts[0].trim(), null, null, null);
                        commands.add(command);
                        System.out.println("Single part command: " + parts[0].trim());
                        break;
                    case 2:
                        command = new Command(parts[0].trim(), parts[1].trim(), null, null);
                        commands.add(command);
                        System.out.println("Two part command: " + parts[0].trim() + ", " + parts[1].trim());
                        break;
                    case 3:
                        command = new Command(parts[0].trim(), parts[1].trim(), parts[2].trim(), null);
                        commands.add(command);
                        System.out.println("Three part command: " + parts[0].trim() + ", " + parts[1].trim() + ", " + parts[2].trim());
                        break;
                    case 4:
                        command = new Command(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                        commands.add(command);
                        System.out.println("Four part command: " + parts[0].trim() + ", " + parts[1].trim() + ", " + parts[2].trim() + ", " + parts[3].trim());
                        break;
                    default:
                        System.out.println("Invalid command command: " + commandLine);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return commands;
    }
}
