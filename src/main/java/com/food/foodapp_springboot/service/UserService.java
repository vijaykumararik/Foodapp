package com.food.foodapp_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.food.foodapp_springboot.dao.UserDao;
import com.food.foodapp_springboot.dto.User;
import com.food.foodapp_springboot.responce.ResponseStructure;

import java.util.List;
@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public  List<User> getusers() {
		
		return dao.getusers() ;
	}
	
	
	public ResponseStructure<?> updateuser(Integer id,User user){
		 
	  User user2=dao.updateuser(id, user);
		if(user2!=null) {
			ResponseStructure<User> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated IF data not present then it is created");
			responseStructure.setData(dao.updateuser(id, user));
			return responseStructure;
		}
		else {
			ResponseStructure<Object> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("The id not there so new Id iS Created");
			responseStructure.setData(user);
			return responseStructure;
			
		}
	}
	
	public ResponseStructure<?> loginvalidate(String email,String password){
		
		User user=dao.loginvalidate(email, password);
		if(user!=null) {
			if(user.getUserPassword().equals(password)) {
			  ResponseStructure<User> responseStructure =new ResponseStructure<>();
			  responseStructure.setStatus(HttpStatus.FOUND.value());
			  responseStructure.setMessage("User Login successful");
			  responseStructure.setData(user);
			  return responseStructure;
			}else {
				 ResponseStructure<User> responseStructure =new ResponseStructure<>();
				  responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
				  responseStructure.setMessage("Invalid login crendials");
				  return responseStructure;
				
			}
		}else {
			 ResponseStructure<User> responseStructure =new ResponseStructure<>();
			  responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			  responseStructure.setMessage("Invalid login crendials");
			  return responseStructure;
			
		}
	}
	
	
}
