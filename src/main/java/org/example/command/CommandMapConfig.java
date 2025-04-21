package org.example.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CommandMapConfig {

    @Bean("commandMap")
    public Map<String, Command> commandMap() {

        Map<String, Command> commands = new HashMap<>();

        commands.put("user_create", new CreateUserCommand());
        commands.put("show_all_users", new ShowAllUsersCommand());

        return  commands;
    }

}
