package com.yihoyoung.controller;

import com.yihoyoung.config.SecurityConfig;
import com.yihoyoung.domain.Fallow;
import com.yihoyoung.domain.User;
import com.yihoyoung.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.Calendar;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by hoyounglee on 2016. 8. 7..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@EnableAutoConfiguration(exclude = { SecurityConfig.class})
public class FallowControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestRestTemplate rest;

    String baseUrl;
    @Value("${local.server.port}")
    int port;

    User user1;
    User user2;

    @Before
    public void setting(){
        user1 = new User();
        user1.setEmail("james@naver.com");
        user1.setPassword("111");
        user1.setCreatedAt(Calendar.getInstance());

        user2 = new User();
        user2.setEmail("james@naver.com");
        user2.setPassword("111");
        user2.setCreatedAt(Calendar.getInstance());

        baseUrl = "http://localhost:" +  String.valueOf(port);
    }

    @Test
    public void addToFallow(){
        userRepository.save(user1);
        userRepository.save(user2);

        List<Fallow> fallows = user1.getFallows();

        URI uri = URI.create(baseUrl+ "/user/fallow/" + user2.getUserId());
        rest.postForEntity(uri, user1, User.class);

        boolean isFallowee = false;
        for (Fallow fallow: fallows) {
            if(fallow.getFallow().getUserId() == user2.getUserId()){
                isFallowee = true;
                break;
            }
        }
        assertThat(isFallowee).isTrue();
    }

    @Test
    public void unFallow(){
        userRepository.save(user1);
        userRepository.save(user2);

        List<Fallow> fallows = user1.getFallows();

        URI uri = URI.create(baseUrl+ "/user/fallow/" + user2.getUserId());
        rest.postForEntity(uri, user1, User.class);

        boolean isFallowee = false;
        for (Fallow fallow: fallows) {
            if(fallow.getFallow().getUserId() == user2.getUserId()){
                isFallowee = true;
                break;
            }
        }
        assertThat(isFallowee).isTrue();
    }
}
