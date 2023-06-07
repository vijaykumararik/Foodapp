package com.food.foodapp_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodapp_springboot.dto.User;
import com.food.foodapp_springboot.repo.UserRepo;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
 @Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public List<User> getusers() {
		
		return repo.findAll();
	}
	
	public User findbyid(Integer id) {
		
		Optional<User> optional=repo.findById(id);
		return  optional.get() ;
	}
	public User updateuser(Integer id,User user) {
		User u1=repo.findById(id).orElse(null);
		if(u1!=null) {
			u1.setUserId(id);
			u1.setUserName(user.getUserName());
			u1.setUserEmail(user.getUserEmail());
			u1.setUserAddress(user.getUserAddress());
			u1.setUserPassword(user.getUserPassword());
			
			return repo.save(u1);
		}else {
			
		return repo.save(user);
		
		}
	}
	
	public User loginvalidate(String email,String password) {
		 
		 User user=repo.validate(email);
		return user;
	}
	
	
	
}
