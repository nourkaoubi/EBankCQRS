package com.example.demo.query.entities;

import com.example.demo.commonapi.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date timestamp ;
    private double amount ;

    @Enumerated(EnumType.STRING)
    private TransactionType type ;
    @ManyToOne
    private Account account;
}
