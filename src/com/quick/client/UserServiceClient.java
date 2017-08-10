package com.quick.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.quick.user.domain.User;
import com.quick.user.service.UserService;

public class UserServiceClient {

	public static void main(String[] args) {

		AbstractApplicationContext container = new GenericXmlApplicationContext("com/quick/common/applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");

		User user = new User();
		/*------------------
		 * Insert
		 * ------------------	  
		  	User user = new User();
			user.setId("test");
			user.setPwd("1234");
			user.setName("관리자");
			user.setRole("1");
			userService.insertUser(user);
		*/

		/*-------------
		 *select (Logi)
		 *-------------
			  User user = userService.getUser("test", "1234"); 
			
			  if(user != null){
			  	System.out.println(user.getName()+"님 환영"); 
			  }else{
			  	System.out.println("실패"); 
			  }
		 */

		userService.deleteUser("mmdk", "1111");

		container.close();
	}

}
