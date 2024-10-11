package com.example.demo.commonapi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand <T> {
    @TargetAggregateIdentifier
    @Getter private T id ;

    public T getId() {
        return id;
    }

    public BaseCommand(T id) {
        this.id = id;
    }
}
