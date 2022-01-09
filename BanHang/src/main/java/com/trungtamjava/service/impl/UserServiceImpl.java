package com.trungtamjava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.dao.UserDAO;
import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	public void addUser(User user) {
		userDAO.addUser(user);

	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

}
