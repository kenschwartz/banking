package com.kennethmschwartz.app.banking.controller;

import com.kennethmschwartz.app.banking.bean.Transaction;
import com.kennethmschwartz.app.banking.service.TransactionService;
import com.kennethmschwartz.app.banking.service.TransactionServiceImpl;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ToString
@Slf4j
@RestController
@RequestMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(final TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{acctNbr}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> findAllByAccountNumber(@PathVariable("acctNbr") String accountNumberStr) {
        int accountNumber;
        try {
            accountNumber = Integer.parseInt(accountNumberStr);
        } catch (Exception e) {
            log.error(String.format("Error parsing [%s] as an integer: %s", accountNumberStr, e.getMessage()));
            return ResponseEntity
                    .badRequest()
                    .body(transactionService.emptyTransactions());
        }

        List<Transaction> transactions;
        try {
            transactions = transactionService.findAllByAccountNumber(accountNumber);
        } catch (Exception e) {
            log.error(String.format("Error retrieving accounts for [%d]: %s", accountNumber, e.getMessage()));
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(transactionService.emptyTransactions());
        }

        return ResponseEntity.ok(transactions);
    }
}
