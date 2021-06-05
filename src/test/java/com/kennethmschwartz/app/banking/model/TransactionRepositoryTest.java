package com.kennethmschwartz.app.banking.model;

import com.kennethmschwartz.app.banking.bean.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

class TransactionRepositoryTest {

    Transaction t;
    ZonedDateTime dateTime = Transaction.fromEST(14, 7, 11, 5, 2021);

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        t = setUpTransaction();
    }

    @Test
    void findAllByAccountNumber() {
        assertNotNull(transactionRepository);
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

    @AfterEach
    void tearDown() {
    }

    @Test
    @Transactional
    void insert() {
        assertNotNull(transactionRepository);
        var savedT = transactionRepository.saveAndFlush(t);
        transactionRepository.flush();
        assertNotNull(savedT);
        assertNotNull(savedT.getId());
        t = savedT;
        var t2 = transactionRepository.findById(t.getId());
        assertTrue(t2.isPresent());
        assertEquals(t.getId(), t2.get().getId());
    }
}
