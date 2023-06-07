package com.food.foodapp_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.food.foodapp_springboot.dto.User;
import com.food.foodapp_springboot.responce.ResponseStructure;
import com.food.foodapp_springboot.service.UserService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsetController {
@Autowired
	private UserService service;
@PostMapping(path = "/save")
public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
}
@GetMapping(path = "/getusers")
public List<User> getusers(){
	return service.getusers();
}

@PutMapping(path = "/updateuser")
  ResponseStructure<?> updateuser(@RequestParam Integer id,@RequestBody User user){
	 ResponseStructure<?> responseStructure= service.updateuser(id, user);
	return responseStructure;
	    
  }

@GetMapping(path = "/login")
ResponseStructure<?> loginvalidate(@RequestParam String email,@RequestParam String password){
	ResponseStructure<?> responseStructure=service.loginvalidate(email, password);
	return responseStructure;
}

	
}
