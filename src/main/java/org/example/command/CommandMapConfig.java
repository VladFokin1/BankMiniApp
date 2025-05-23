package org.example.command;

import org.example.service.AccountService;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CommandMapConfig {

    private final UserService userService;
    private final AccountService accountService;

    public CommandMapConfig(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Bean("commandMap")
    public Map<String, Command> commandMap() {

        Map<String, Command> commands = new HashMap<>();

        commands.put("user_create", new CreateUserCommand(userService));
        commands.put("show_all_users", new ShowAllUsersCommand(userService));
        commands.put("account_create", new CreateAccountCommand(accountService));
        commands.put("account_deposit", new DepositAccountCommand(accountService));
        commands.put("account_withdraw", new WithdrawAccountCommand(accountService));
        commands.put("account_transfer", new TransferAccountCommand(accountService));

        return  commands;
    }

}
