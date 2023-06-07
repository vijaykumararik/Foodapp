package com.food.foodapp_springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.foodapp_springboot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select * from User where user_email=?1 ",nativeQuery = true)
	public User validate(String email);
}
