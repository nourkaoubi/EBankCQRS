package com.example.demo.commonapi.commands;

import lombok.Getter;

public class DebitAccountCommand extends BaseCommand<String> {

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Getter private String currency;
    @Getter private double amount ;
    public DebitAccountCommand(String id, String currency,double amount){
        super(id);
        this.currency=currency;
        this.amount=amount;
    }

}
