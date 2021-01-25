package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

//https://spring.pleiades.io/guides/gs/testing-web/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIsNotNull() throws Exception {

        assertThat(controller).isNotNull();

    }

    @Test
    public void testGetRequest() throws Exception {
        String requestResult = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
        assertThat(requestResult).isEqualTo("hello spring");
    }


}
