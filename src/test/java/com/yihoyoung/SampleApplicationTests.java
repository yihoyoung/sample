package com.yihoyoung;

import com.yihoyoung.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApplicationTests {

	@Autowired
	SecurityConfig securityConfig;

	@Autowired
    WebApplicationContext wac;

	@Test
	public void contextLoads() {
		SecurityConfig securityConfigFromContext = (SecurityConfig) wac.getBean("securityConfig");
		assertTrue(securityConfigFromContext.equals(securityConfig));
	}

}
