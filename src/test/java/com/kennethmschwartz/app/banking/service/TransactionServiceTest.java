package com.kennethmschwartz.app.banking.service;

import com.kennethmschwartz.app.banking.bean.Currency;
import com.kennethmschwartz.app.banking.model.Transaction;
import com.kennethmschwartz.app.banking.model.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    ZonedDateTime dateTime = Transaction.fromEST(14, 7, 11, 5, 2021);

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTransactionCount() {
        when(transactionRepository.findAllByAccountNumber(anyInt()))
                .thenReturn(transactions());

        var transactionService = new TransactionServiceImpl(transactionRepository);
        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }

    private List<Transaction> transactions() {
        return List.of(
                Transaction
                        .builder()
                        .type("credit")
                        .date(dateTime)
                        .accountNumber(1234567)
                        .currency(Currency.USD)
                        .amount(BigDecimal.valueOf(100.00))
                        .merchantName("acme")
                        .merchantLogo("images/acme-logo.png")
                        .build()
        );
    }
}
