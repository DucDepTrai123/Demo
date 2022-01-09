package com.trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/khach-hang", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<User> users = userService.getAllUser();
		request.setAttribute("users", users);
	return"listuser";
	}
	@RequestMapping(value = "/chi-tiet-nguoi-dung/{userid}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request,
			@PathVariable (name = "userid" )int userid) {
		
		request.setAttribute("user",userService.getUserById(userid));
	return"viewUser2";
	}
	
}