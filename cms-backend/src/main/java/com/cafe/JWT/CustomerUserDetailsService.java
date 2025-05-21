package com.cafe.JWT;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.cafe.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	 @Autowired
	    UserDao userDao;

	    private com.cafe.POJO.User userDetails;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        userDetails = userDao.findByEmailId(username);
	        if(!Objects.isNull(userDetails)){
	            return new User(userDetails.getEmail(), userDetails.getPassword(),new ArrayList<>());
	        }
	        else{
	            throw new UsernameNotFoundException("User not found.");
	        }
	    }

	    public com.cafe.POJO.User getUserDetails(){
	    	 return userDetails;
	    }

}
