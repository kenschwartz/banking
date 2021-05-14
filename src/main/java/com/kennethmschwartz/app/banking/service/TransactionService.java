package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.bean.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAllByAccountNumber(final int accountNumber);
    List<Transaction> emptyTransactions();
}
