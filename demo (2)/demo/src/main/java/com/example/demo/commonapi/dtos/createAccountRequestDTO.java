package com.example.demo.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Builder
@Data
public class createAccountRequestDTO {
     private String currency;
    private double initialBalance;

    public String getCurrency() {
        return currency;
    }

    public double getInitialBalance() {
        return initialBalance;
    }
}
