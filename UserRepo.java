package com.example.demo.userrepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);

}
