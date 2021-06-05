package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.bean.Currency;
import com.kennethmschwartz.app.banking.model.Transaction;
import com.kennethmschwartz.app.banking.model.TransactionRepository;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ToString
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionServiceImpl(final TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> findAllByAccountNumber(@NonNull final Integer accountNumber) {
        return repository.findAllByAccountNumber(accountNumber);
    }

    public List<Transaction> emptyTransactions() {
        return new ArrayList<>();
    }
}
