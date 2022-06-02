package com.amaris.java_test.prices;

import com.amaris.java_test.JavaTestApplication;
import com.amaris.java_test.prices.core.application.domain.wrapper.PricesWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ObjectUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JavaTestApplication.class)
@AutoConfigureMockMvc
public class PricesControllerIntegrationTest {

    @Autowired private MockMvc mvc;

    @LocalServerPort private int port;

    @Autowired private TestRestTemplate restTemplate;

    private final String URL = "/prices/";

    private final ObjectMapper MAPPER = new ObjectMapper();

    private String body(Object obj) {
        if (ObjectUtils.isEmpty(obj))
            return "";
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    @Test public void test1() throws Exception {
        init(1);
        mvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
                .content(body(new PricesWrapper("2020-06-14 10:00:00", 35455, 1)))).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test public void test2() throws Exception {
        init(2);
        mvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
                .content(body(new PricesWrapper("2020-06-14 16:00:00", 35455, 1)))).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test public void test3() throws Exception {
        init(3);
        mvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
                .content(body(new PricesWrapper("2020-06-14 21:00:00", 35455, 1)))).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test public void test4() throws Exception {
        init(4);
        mvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
                .content(body(new PricesWrapper("2020-06-15 10:00:00", 35455, 1)))).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test public void test5() throws Exception {
        init(5);
        mvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
                .content(body(new PricesWrapper("2020-06-16 21:00:00", 35455, 1)))).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    private void init(int number) {
        System.out.println("\nPROCESS TEST - " + number);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
