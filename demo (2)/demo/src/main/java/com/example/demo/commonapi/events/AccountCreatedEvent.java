package com.example.demo.commonapi.events;

import com.example.demo.commonapi.enums.AccountStatus;

public class AccountCreatedEvent extends BaseEvent<String>{

     private String currency;
    private double balance;
    private AccountStatus status;
    public AccountCreatedEvent(String id, String currency, double balance, AccountStatus status) {
        super(id);
        this.currency = currency;
        this.balance = balance;
        this.status=status;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
