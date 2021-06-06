package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.model.Transaction;
import lombok.NonNull;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAllByAccountNumber(@NonNull final Integer accountNumber);

    List<Transaction> emptyTransactions();
}
