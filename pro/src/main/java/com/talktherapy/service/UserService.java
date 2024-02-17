package com.talktherapy.service;

import java.util.List;
import com.talktherapy.model.User;


public interface UserService {
	//for creating user
	User addUser(User user);
	
	//for updating user
	User updateUser(User user);
	
	//for deleting user
	void deleteUser(long userId);
	
	//to find specific user
	User getUserById(long id);
	
	//list of all users
	List<User>getAllUsers();

}
