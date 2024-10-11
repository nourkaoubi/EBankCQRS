package com.example.demo.commands.controllers;

import com.example.demo.commonapi.commands.CreateAccountCommand;
import com.example.demo.commonapi.commands.CreditAccountCommand;
import com.example.demo.commonapi.commands.DebitAccountCommand;
import com.example.demo.commonapi.dtos.CreditAccountRequestDTO;
import com.example.demo.commonapi.dtos.DebitAccountRequestDTO;
import com.example.demo.commonapi.dtos.createAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.axonframework.eventsourcing.eventstore.EventStore;

@RestController
@RequestMapping ("/commands/account")
public class AccountCommandController {
    private CommandGateway commandGateway;
    private  EventStore eventStore;

    public AccountCommandController (CommandGateway commandGateway ,EventStore eventStore){
        this.commandGateway=commandGateway;
        this.eventStore = eventStore;
    }


    @PostMapping("/create")
    public CompletableFuture<String> createNewAccount(@RequestBody createAccountRequestDTO request){
        return  commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),request.getCurrency(),request.getInitialBalance()));
    }

    @PostMapping("/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO request){
        return  commandGateway.send(new DebitAccountCommand(request.getAccountId(), request.getCurrency(), request.getAmount()));
    }

    @PostMapping("/crebit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO request){
        return  commandGateway.send(new CreditAccountCommand(request.getAccountId(), request.getCurrency(), request.getAmount()));
    }

    @GetMapping ("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
