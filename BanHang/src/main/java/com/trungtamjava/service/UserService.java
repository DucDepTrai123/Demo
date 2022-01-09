package com.trungtamjava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trungtamjava.model.User;

@Service
public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User getUserById(int id);

	public List<User> getAllUser();
}
