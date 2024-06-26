package com.example.demo.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.userrepo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerUser(String userName, String password) {
		User user = new User();
		String encode = passwordEncoder.encode(password);
		user.setUserName(userName);
		user.setPassword(encode);

		return userRepo.save(user);

	}

	public void login(String userName, String password) {
		String encode = passwordEncoder.encode(password);
		User user = new User();
		user.setUserName(userName);
		user.setPassword(encode);
		userRepo.save(user);
	}

	public User getuser(String userName) {
		return userRepo.findByUserName(userName).orElse(null);
	}

}
