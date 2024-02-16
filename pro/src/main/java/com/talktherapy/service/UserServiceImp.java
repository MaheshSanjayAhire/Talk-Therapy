package com.talktherapy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.talktherapy.model.User;
import com.talktherapy.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	//this method is provide by JPA
	@Override
	public User addUser(User user) {
		return ur.save(user);
	}

	@Override
	public User updateUser(User user) {
		return ur.save(user);
	}

	@Override
	public void deleteUser(long id) {
		ur.deleteById(id);
	}

	@Override
	public User getUserById(long id) {
		Optional<User>user=ur.findById(id);
		 if(user.isPresent())
		 {
			 return user.get();
		 }
		 return null;
	}

	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}
}
