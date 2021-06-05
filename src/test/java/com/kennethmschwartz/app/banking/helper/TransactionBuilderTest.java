package com.kennethmschwartz.app.banking.helper;

import com.kennethmschwartz.app.banking.helper.TransactionBuilder;
import com.kennethmschwartz.app.banking.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionBuilderTest {

    @Test
    void buildTransactionsFromCsv() throws IOException {
        var x = new TransactionBuilder().buildTransactionsFromCsv();
        var z = new ArrayList<Transaction>();
        assertEquals(z, x);
    }
}
