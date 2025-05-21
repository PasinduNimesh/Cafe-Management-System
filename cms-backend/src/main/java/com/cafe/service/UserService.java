package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.cafe.wrapper.UserWrapper;


public interface UserService {
	
	public ResponseEntity<String> signUp(Map<String, String> requestMap);
	//public ResponseEntity<String> signUpSimple(Map<String, String> requestMap);
	
	public ResponseEntity<String> login(Map<String, String> requestMap);
	
	public ResponseEntity<List<UserWrapper>> getAllUsers();
	
	public ResponseEntity<String> update(Map<String,String> requesrtMap);
	 
	public ResponseEntity<String> checkToken();
	
	public ResponseEntity<String> changePassword(Map<String, String> requestMap);
	
	public ResponseEntity<String> forgotPassword(Map<String, String> requestMap);

}
