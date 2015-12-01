package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	public User findById() {
		return userRepository.findById();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User created(User user) {
		return userRepository.save(user);
	}
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}
}
