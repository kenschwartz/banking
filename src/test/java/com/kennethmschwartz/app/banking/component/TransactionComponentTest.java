package com.kennethmschwartz.app.banking.component;

import com.kennethmschwartz.app.banking.model.TransactionRepository;
import com.kennethmschwartz.app.banking.service.TransactionServiceImpl;
import com.kennethmschwartz.app.banking.web.TransactionController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApplicationEndToEnd() {
        given().standaloneSetup(new TransactionController(
                new TransactionServiceImpl(transactionRepository)))
                .when()
                .get(String.format("http://localhost:%s/api/v1/transactions/1234567", port))
                .then()
                .statusCode(Matchers.is(200));
    }
}
