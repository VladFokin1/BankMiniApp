package org.example;

import org.example.command.Command;
import org.example.command.CommandFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OperationsConsoleListener {


    private final CommandFactory commandFactory;

    public OperationsConsoleListener(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        startListenConsole();
    }

    public void startListenConsole() {
        new Thread(() -> {

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(getCommandsString());
                String input = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                processCommand(input);
            }
            scanner.close();

        }).start();
    }

    private String getCommandsString() {
        StringBuilder result = new StringBuilder("Enter command:\n");
        String[] names = commandFactory.getAllCommandsNameArray();
        for (int i = 0; i < names.length; i++) {
            result.append("-").append(names[i].toUpperCase()).append("\n");
        }
        return result.toString();
    }

    private void processCommand(String input) {
        Command command = commandFactory.getCommand(input.toLowerCase());
        command.execute();
    }
}
