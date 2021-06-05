package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.bean.Currency;
import com.kennethmschwartz.app.banking.model.Transaction;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ToString
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    public List<Transaction> findAllByAccountNumber(final int accountNumber) {
        //ArrayList<Transaction> list = new ArrayList<>();
        return List.of(
                Transaction
                        .builder()
                        .type("credit")
                        .date(Transaction.fromEST(14, 7, 11, 5, 2021))
                        .accountNumber(accountNumber)
                        .currency(Currency.USD)
                        .amount(BigDecimal.valueOf(100))
                        .merchantName("acme")
                        .merchantLogo("images/acme-logo.png")
                        .build()
        );
    }

    public List<Transaction> emptyTransactions() {
        return new ArrayList<>();
    }
}
