package com.hyunjin.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

	@Test
	public void 해쉬_암호화(){
		String encPassword = new BCryptPasswordEncoder().encode("1234");
		System.out.println("1234: 해쉬 "+encPassword);
//		1234: 해쉬 $2a$10$yarlQp4wbTHx.bQibdn8Q.3dSBHy.KJBxQNgJW36wUd819B9VlBqi
	}
	
}
