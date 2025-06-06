package com.cafe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.cafe.POJO.User;
import com.cafe.wrapper.UserWrapper;

public interface UserDao extends JpaRepository<User, Integer>{

	
	public User findByEmailId(@Param("email") String email);
	
	List<UserWrapper> getAllUsers();
	
	List<String> getAllAdmin();
	
	@Transactional
	@Modifying
	Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
	
	User findByEmail(String email);
	
	
}
