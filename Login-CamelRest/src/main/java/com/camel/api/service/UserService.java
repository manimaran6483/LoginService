
package com.camel.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.api.model.User;
import com.camel.api.repository.UserRepository;
import com.camel.api.request.UserRequest;
import com.camel.api.response.UserResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserResponse validateUser(UserRequest user) {
		System.out.println("service called");
		//User u = userRepo.findUserByUsername(user.getUsername());
		User up = userRepo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(up==null) {
			return new UserResponse("Credentials are Invalid");
		}else {
			return new UserResponse("Credentials are valid");
		}
	}
}
