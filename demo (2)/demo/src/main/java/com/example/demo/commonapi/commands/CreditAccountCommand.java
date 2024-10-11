package com.example.demo.commonapi.commands;

import lombok.Getter;

public class CreditAccountCommand extends BaseCommand<String> {

    @Getter private String currency;

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Getter private double amount ;
    public CreditAccountCommand(String id, String currency,double amount){
        super(id);
        this.currency=currency;
        this.amount=amount;
    }
}
