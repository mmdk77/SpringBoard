package com.quick.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.quick.user.domain.User;
import com.quick.user.service.UserService;

public class UserServiceClient {

	public static void main(String[] args) {

		AbstractApplicationContext container = new GenericXmlApplicationContext("com/quick/common/applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");

		User user = new User();
		user.setId("test");
		user.setPwd("1234");
		user.setName("包府磊");
		user.setRole("包府磊");
		
		
		container.close();
	}

}
