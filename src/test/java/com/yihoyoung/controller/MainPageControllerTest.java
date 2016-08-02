package com.yihoyoung.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by hoyounglee on 2016. 7. 27..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainPageControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void mainPageTest() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("Hello, World");
    }

    @Test
    public void wrongPageRequestTest(){
        String body =
                this.restTemplate.getForEntity("/wrongPage", String.class).getBody();
        assertThat(body).contains("<html><head><title>Login Page</title></head>");
    }
}
