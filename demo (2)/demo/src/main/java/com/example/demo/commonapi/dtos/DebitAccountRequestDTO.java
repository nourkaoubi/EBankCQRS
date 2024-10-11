package com.example.demo.commonapi.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebitAccountRequestDTO {

   private String currency;
    private double amount;
    @Getter private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
