package com.yihoyoung.repository;

import com.mysql.fabric.xmlrpc.base.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.yihoyoung.domain.User;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    public UserRepository userRepository;

    private User user;

    @Before
    public void setting(){
        user = new User();
        user.setEmail("yihoyoung@nate1.com");
        user.setPassword("password");
        user.setCreatedAt(Calendar.getInstance());
    }

    @Test
    public void testCreateUser(){
        User savedUser = userRepository.save(user);
        assertThat(user).isEqualTo(savedUser);
    }
}
