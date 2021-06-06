package com.kennethmschwartz.app.banking.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    /*
    CREATE DATABASE banking DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
    GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON banking.* TO 'bank'@'%' IDENTIFIED BY 'bank';
    jdbc:mariadb://localhost:13306/banking
     */

    List<Transaction> findAllByAccountNumber(final Integer accountNumber);
}
