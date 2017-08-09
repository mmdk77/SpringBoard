package com.quick.user.service;

import java.util.List;

import com.quick.user.domain.User;
import com.quick.user.repository.UserDAOJdbc;

public class UserServiceImpl implements UserService{
	
	private UserDAOJdbc userDAO;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDAO.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(String id, String pwd) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(id, pwd);
	}

	@Override
	public User getUser(String id, String pwd) {
		// TODO Auto-generated method stub
		return userDAO.getUser(id, pwd);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDAO.getUserList();
	}
	

}
