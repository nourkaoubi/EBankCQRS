package com.example.demo.commonapi.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditAccountRequestDTO {
    private String currency;
    private double amount;

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }

    @Getter
    private String accountId;
}
