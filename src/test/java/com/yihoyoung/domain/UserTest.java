package com.yihoyoung.domain;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
public class UserTest {
    @Test
    public void testUserSet(){
        String email = "james@sample.com";
        User user = new User();
        user.setEmail(email);
        assertThat(email).isEqualTo(user.getEmail());
    }
}
