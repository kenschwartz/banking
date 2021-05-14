package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.OpenBankingAppApplication;
import com.kennethmschwartz.app.banking.bean.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OpenBankingAppApplication.class)
class TransactionServiceTest {

    @Autowired
    private TransactionServiceImpl transactionService;

    @Test
    void findAllByAccountNumber() {
        assertNotNull(transactionService);
        assertEquals(1, transactionService.findAllByAccountNumber(0).size());
    }

    @Test
    void emptyTransactions() {
    }
}
