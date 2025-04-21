package org.example.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {
    private final Map<String, Command> commands;

    public CommandFactory(Map<String, Command> commands) {
        this.commands = commands;
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public String[] getAllCommandsNameArray() {
        return commands.keySet().toArray(new String[0]);
    }
}
