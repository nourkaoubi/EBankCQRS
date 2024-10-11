package com.example.demo.query.entities;

import com.example.demo.commonapi.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    private String id ;
    private Instant createdAt ;


    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setTransactions(List<AccountTransaction> transactions) {
        this.transactions = transactions;
    }

    private double balance ;
    private AccountStatus status ;
    private String currency;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> transactions;
}
