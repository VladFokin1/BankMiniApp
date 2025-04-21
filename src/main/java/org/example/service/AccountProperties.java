package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AccountProperties {
    @Value("${account.default-amount}")
    private double defaultAmount;

    @Value("${account.transfer-commission}")
    private double transferCommission;


    public double getDefaultAmount() {
        return defaultAmount;
    }

    public double getTransferCommission() {
        return transferCommission;
    }
}
