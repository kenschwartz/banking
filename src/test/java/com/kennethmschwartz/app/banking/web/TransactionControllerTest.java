package com.kennethmschwartz.app.banking.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TransactionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private TransactionController controller;
    @Autowired
    private MockMvc mockMvc;

    private String url;

    @BeforeEach
    void setUp() {
        url = String.format("http://localhost:%d/api/v1/transactions", port);
    }

    @Test
    void findAllByAccountNumber() {
        assertThat(controller).isNotNull();
        String urlToUse = String.format("%s/1", url);
        final ResponseEntity<String> result = this.restTemplate.getForEntity(urlToUse, String.class);
        assertNotNull(result.getBody());
        System.out.printf("-----\nBody: %s\n-----\n", result.getBody());
        assertEquals(MediaType.APPLICATION_JSON, result.getHeaders().getContentType());

        urlToUse = String.format("%s/x", url);
        final ResponseEntity<String> result2 = this.restTemplate.getForEntity(urlToUse, String.class);
        assertNotNull(result2.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), result2.getStatusCodeValue());
    }

    @Test
    void testToString() {
    }
}
