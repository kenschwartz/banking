package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.model.Transaction;
import com.kennethmschwartz.app.banking.model.TransactionRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAllByAccountNumber(@NonNull final Integer accountNumber);

    List<Transaction> emptyTransactions();
}
