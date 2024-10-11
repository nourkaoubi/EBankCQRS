package com.example.demo.query.services;

import com.example.demo.commonapi.events.AccountCreatedEvent;
import com.example.demo.query.entities.Account;
import com.example.demo.query.queries.GetAllAccounts;
import com.example.demo.query.repository.AccountRepository;
import com.example.demo.query.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountEventHandlerService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public AccountEventHandlerService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }
    @EventHandler
    public void on(AccountCreatedEvent event, EventMessage<AccountCreatedEvent> eventMessage){
        System.out.println("***************************************");
        System.out.println("Account rep recieved");

        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getBalance());
        account.setStatus(event.getStatus());
        account.setCurrency(event.getCurrency());
        account.setCreatedAt((eventMessage.getTimestamp()));
        accountRepository.save(account);

    }
    @QueryHandler
    public List<Account> on(GetAllAccounts query){
        return accountRepository.findAll();
    }
}
