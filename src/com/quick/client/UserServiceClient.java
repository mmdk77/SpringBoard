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
			user.setName("������");
			user.setRole("1");
			userService.insertUser(user);
		*/

		/*-------------
		 *select (Logi)
		 *-------------
			  User user = userService.getUser("test", "1234"); 
			
			  if(user != null){
			  	System.out.println(user.getName()+"�� ȯ��"); 
			  }else{
			  	System.out.println("����"); 
			  }
		 */

		userService.deleteUser("mmdk", "1111");

		container.close();
	}

}
