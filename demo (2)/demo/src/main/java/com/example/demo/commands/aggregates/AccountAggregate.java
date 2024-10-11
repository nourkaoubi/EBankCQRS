package com.example.demo.commands.aggregates;

import com.example.demo.commonapi.commands.CreateAccountCommand;
import com.example.demo.commonapi.commands.CreditAccountCommand;
import com.example.demo.commonapi.commands.DebitAccountCommand;
import com.example.demo.commonapi.enums.AccountStatus;
import com.example.demo.commonapi.events.AccountCreatedEvent;
import com.example.demo.commonapi.events.AccountCreditedEvent;
import com.example.demo.commonapi.events.AccountDebitedEvent;
import com.example.demo.commonapi.exeptions.NegativeInitialBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private  String currency;
    private double balance ;
    private AccountStatus status;

    public AccountAggregate() {
    }
    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if(command.getInitialBalance()<0)throw new NegativeInitialBalanceException("negative balance");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getCurrency(),
                command.getInitialBalance(),
                AccountStatus.CREATED
        ));
    }
@EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accountId=event.getId();
        this.balance=event.getBalance();
        this.currency=event.getCurrency();
        this.status=event.getStatus();

}

    @CommandHandler
    public void handle(CreditAccountCommand command){
        if(command.getAmount()<0) throw new NegativeInitialBalanceException("Negative Amount");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getCurrency(),
                command.getAmount()
        ));
    }
    @EventSourcingHandler
    public void on (AccountCreditedEvent event){

        this.balance+= event.getAmount();


    }
    @CommandHandler
    public void handle(DebitAccountCommand command){
        if(command.getAmount()<0) throw new NegativeInitialBalanceException("Negative Amount");
        if(command.getAmount()>this.balance) throw new RuntimeException("Balance insufficient Exception");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getCurrency(),
                command.getAmount()
        ));
    }
    @EventSourcingHandler
    public void on (AccountDebitedEvent event){

        this.balance-= event.getAmount();


    }


}
