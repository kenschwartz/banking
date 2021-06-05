package com.kennethmschwartz.app.banking.bean;

import com.kennethmschwartz.app.banking.model.Transaction;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionBuilder {

    @Bean
    public List<Transaction> buildTransactionsFromCsv() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {
            String line = null;
            int count = 0;
            do {
                line = reader.readLine();
                count++;
                if ((count > 2) && line != null) {
                    String[] transactionString = line.split(";");
                    var x = Transaction.builder()
                            .type(transactionString[0].trim())
                            .date(ZonedDateTime.parse(transactionString[1].trim()))
                            .accountNumber(Integer.parseInt(transactionString[2].trim()))
                            .currency(Currency.valueOf(transactionString[3].trim()))
                            .amount(new BigDecimal(transactionString[4].trim()))
                            .merchantName(transactionString[5].trim())
                            .merchantLogo(transactionString[6].trim())
                            .build();
                    transactions.add(x);
                }
            } while (line != null);

        }

        return transactions;
    }
}
