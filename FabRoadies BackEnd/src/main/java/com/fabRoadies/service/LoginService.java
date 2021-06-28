package com.fabRoadies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.User;
import com.fabRoadies.repo.UserRepo;

/** 
 * @author Pratik 
 * @version 1.0
 */
@Service
public class LoginService {

	@Autowired
    private UserRepo userRepository;
	public User getByEmailPassword(String uemail, String upassword) {
		// TODO Auto-generated method stub
		return userRepository.getByEmailPassword(uemail,upassword);
	
		
	}

}
