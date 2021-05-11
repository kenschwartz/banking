package com.kennethmschwartz.app.banking.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction t;
    ZonedDateTime dateTime = Transaction.fromEST(14, 7, 11, 5, 2021);

    @BeforeEach
    void setUp() {
        t = setUpTransaction();
    }

    private Transaction setUpTransaction() {
        return Transaction.builder()
                .type("x")
                .date(dateTime)
                .accountNumber("1")
                .currency(Currency.USD)
                .amount(BigDecimal.valueOf(0))
                .merchantName("Ken's")
                .build();
    }

    /*
    @Test
    void of() {
        Transaction t2 = Transaction.of("x", now, "1", Currency.USD, BigDecimal.valueOf(0), "ken's");
        assertEquals(t2, t);
    }
     */

    @Test
    void builder() {
        Transaction t2 = new Transaction();
        t2.setType("x");
        t2.setDate(dateTime);
        t2.setAccountNumber("1");
        t2.setCurrency(Currency.USD);
        t2.setAmount(BigDecimal.valueOf(0));
        t2.setMerchantName("Ken's");
        assertEquals(t, t2);
    }

    @Test
    void getType() {
        assertEquals("x", t.getType());
    }

    @Test
    void getDate() {
        assertEquals(dateTime, t.getDate());
    }

    @Test
    void getAccountNumber() {
        assertEquals("1", t.getAccountNumber());
    }

    @Test
    void getCurrency() {
        assertEquals(Currency.USD, t.getCurrency());
    }

    @Test
    void getAmount() {
        assertEquals(BigDecimal.valueOf(0), t.getAmount());
    }

    @Test
    void getMerchantName() {
        assertEquals("Ken's", t.getMerchantName());
    }

    @Test
    void getMerchantLogo() {
        assertNull(t.getMerchantLogo());
    }

    @Test
    void setType() {
        t.setType("x");
        assertEquals("x", t.getType());
    }

    @Test
    void setDate() {
        ZonedDateTime now2 = ZonedDateTime.now();
        t.setDate(now2);
        assertEquals(now2, t.getDate());
    }

    @Test
    void setAccountNumber() {
        t.setAccountNumber("zzzz");
        assertEquals("zzzz", t.getAccountNumber());
    }

    @Test
    void setCurrency() {
        t.setCurrency(Currency.CAD);
        assertEquals(Currency.CAD, t.getCurrency());
    }

    @Test
    void setAmount() {
        t.setAmount(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), t.getAmount());
    }

    @Test
    void setMerchantName() {
        t.setMerchantName("jen");
        assertEquals("jen", t.getMerchantName());
    }

    @Test
    void setMerchantLogo() {
        t.setMerchantLogo("not now");
        assertEquals("not now", t.getMerchantLogo());
    }

    @Test
    void testEquals() {
        t = setUpTransaction();
        Transaction t2 = setUpTransaction();
        assertEquals(t2, t);
    }

    @Test
    void canEqual() {
        t = setUpTransaction();
        Transaction t2 = new Transaction();
        assertTrue(t.canEqual(t2));
    }

    @Test
    void testToString() {
        t = setUpTransaction();
        assertEquals("Transaction(type=x, date=2021-05-11T14:07-04:00[America/New_York], accountNumber=1, currency=USD, amount=0, merchantName=Ken's, merchantLogo=null)",
                t.toString());
    }

    @Test
    void fromEST() {
        ZonedDateTime dt = Transaction.fromEST(13, 0, 4, 5, 1969);
        assertEquals("1969-05-04T13:00-04:00[America/New_York]", dt.toString());
    }
}
