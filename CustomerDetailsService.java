package com.example.demo.cusstomedetailsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.userrepo.UserRepo;

@Service
public class CustomerDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.findByUserName(name).orElseThrow(() -> new RuntimeException("user not fount"));
		
		 return org.springframework.security.core.userdetails.User
	            .withUsername(user.getUserName())
	            .password(user.getPassword())
	            .authorities("USER")
	            .build();
	}
	
}
