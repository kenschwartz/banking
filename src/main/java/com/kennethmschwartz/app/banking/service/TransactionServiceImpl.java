package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.bean.Transaction;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@ToString
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    public List<Transaction> findAllByAccountNumber(int accountNumber) {
        ArrayList<Transaction> list = new ArrayList<>();
        return list;
    }

    public List<Transaction> emptyTransactions() {
        ArrayList<Transaction> list = new ArrayList<>();
        return list;
    }
}
