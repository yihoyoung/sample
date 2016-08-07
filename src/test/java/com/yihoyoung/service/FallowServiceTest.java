package com.yihoyoung.service;

import com.yihoyoung.domain.Fallow;
import com.yihoyoung.domain.User;
import com.yihoyoung.repository.FallowRepository;
import com.yihoyoung.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by hoyounglee on 2016. 8. 7..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class FallowServiceTest {

    @Autowired
    FallowService fallowService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FallowRepository fallowRepository;

    User user1;
    User user2;

    @Before
    public void setting(){
        user1 = new User();
        user1.setEmail("aaa@bbb");
        user1.setPassword("password");
        user1.setCreatedAt(Calendar.getInstance());

        user2 = new User();
        user2.setEmail("bbb@AAA");
        user2.setPassword("psw2");
        user2.setCreatedAt(Calendar.getInstance());
    }

    @Test
    public void setFallowTest(){
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);

        Fallow fallow = new Fallow();
        fallow.setUser(user1);
        fallow.setFallow(user2);
        Fallow fallow2 = fallowRepository.save(fallow);

        assertThat(fallow2.getFallow()).isEqualTo(user2);
    }
}
