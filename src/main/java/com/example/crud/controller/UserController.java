package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.User;
import com.example.crud.repo.UserRepo;


@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userRepo.findById(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return "Successfully deleted";
	}

}
