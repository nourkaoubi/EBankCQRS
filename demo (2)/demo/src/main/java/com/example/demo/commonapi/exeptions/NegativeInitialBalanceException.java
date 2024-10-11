package com.example.demo.commonapi.exeptions;

public class NegativeInitialBalanceException extends RuntimeException {
    public NegativeInitialBalanceException(String message) {
   super(message);
    }
}
