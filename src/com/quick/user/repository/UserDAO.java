package com.quick.user.repository;

import java.util.List;

import com.quick.user.domain.User;

public interface UserDAO {
	
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(String id,String pwd);
	public User getUser(String id, String pwd);
	public List<User> getUserList();
	

}
