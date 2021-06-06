package com.kennethmschwartz.app.banking.model;

import com.kennethmschwartz.app.banking.OpenBankingAppApplication;
import com.kennethmschwartz.app.banking.bean.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {OpenBankingAppApplication.class})
class TransactionRepositoryTest {

    private final TransactionRepository transactionRepository;
    Transaction t;
    ZonedDateTime dateTime = Transaction.fromEST(14, 7, 11, 5, 2021);

    @Autowired
    public TransactionRepositoryTest(final TransactionRepository repository) {
        this.transactionRepository = repository;
    }

    @BeforeEach
    public void setUp() {
        t = setUpTransaction();
    }

    @AfterEach
    void tearDown() {
    }

    private Transaction setUpTransaction() {
        return Transaction.builder()
                .type("x")
                .date(dateTime)
                .accountNumber(1)
                .currency(Currency.USD)
                .amount(BigDecimal.valueOf(0))
                .merchantName("Ken's")
                .build();
    }

    @Test
    void findAllByAccountNumber() {
        assertNotNull(transactionRepository);
    }

    @Test
    void insert() {
        assertNotNull(transactionRepository);
        var savedT = transactionRepository.saveAndFlush(t);
        assertNotNull(savedT);
        assertNotNull(savedT.getId());
        t = savedT;
        var t2 = transactionRepository.findById(t.getId());
        assertTrue(t2.isPresent());
        assertEquals(t.getId(), t2.get().getId());
    }
}
