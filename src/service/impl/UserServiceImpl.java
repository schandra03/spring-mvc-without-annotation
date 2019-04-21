package service.impl;

import service.defination.UserService;
import domain.User;

public class UserServiceImpl implements UserService {

	public void add(User user) {
		System.out.println("User added successfully");
	}

}