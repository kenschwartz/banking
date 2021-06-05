package com.kennethmschwartz.app.banking.helper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionBuilderTest {

    @Test
    void buildTransactionsFromCsv() throws IOException {
        var x = new TransactionBuilder().buildTransactionsFromCsv();
        assertEquals(6, x.size());
    }
}
