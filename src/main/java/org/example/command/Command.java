package org.example.command;

import org.example.Loggable;

public interface Command {
    @Loggable
    void execute();
}
