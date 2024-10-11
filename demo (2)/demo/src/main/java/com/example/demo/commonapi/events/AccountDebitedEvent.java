package com.example.demo.commonapi.events;

import lombok.Getter;

public class AccountDebitedEvent extends BaseEvent<String>{
    @Getter
    private String currency;
    @Getter private double amount ;

    public AccountDebitedEvent(String id, String currency,double amount){
        super(id);
        this.currency=currency;
        this.amount=amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
