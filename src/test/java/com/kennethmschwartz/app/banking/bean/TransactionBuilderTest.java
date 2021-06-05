package com.kennethmschwartz.app.banking.bean;

import com.kennethmschwartz.app.banking.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionBuilderTest {

    @Test
    void buildTransactionsFromCsv() throws IOException {
        var x = new TransactionBuilder().buildTransactionsFromCsv();
        var z = new ArrayList<Transaction>();
        assertEquals(z, x);
    }
}
