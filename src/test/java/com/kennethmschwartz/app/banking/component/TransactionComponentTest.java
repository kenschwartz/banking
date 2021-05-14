package com.kennethmschwartz.app.banking.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class TransactionComponentTest {

    // https://github.com/spring-projects/spring-framework/blob/main/spring-test/src/test/java/org/springframework/test/web/servlet/samples/standalone/resultmatchers/ContentAssertionTests.java
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = standaloneSetup(new SimpleController()).alwaysExpect(status().isOk()).build();
    }

    @Test
    @Disabled
    public void greeting_controller_returns_json_greeting() throws Exception {
        given().
                //standaloneSetup(new GreetingController()).
                        param("name", "Johan").
                when().
                get("/greeting").
                then().
                statusCode(200).
                body("id", equalTo(1)).
                body("content", equalTo("Hello, Johan!"));

        this.mockMvc.perform(get("/handle").accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Hello world!"));

        this.mockMvc.perform(get("/handleUtf8"))
                .andExpect(content().string("\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01"));
    }

    @Controller
    private static class SimpleController {

        @RequestMapping(value = "/handle", produces = "text/plain")
        @ResponseBody
        public String handle() {
            return "Hello world!";
        }

        @RequestMapping(value = "/handleUtf8", produces = "text/plain;charset=UTF-8")
        @ResponseBody
        public String handleWithCharset() {
            return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01";    // "Hello world! (Japanese)
        }
    }

}
