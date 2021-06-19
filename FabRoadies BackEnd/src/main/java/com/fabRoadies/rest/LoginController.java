package com.fabRoadies.rest;

import java.util.Base64;
import java.util.Base64.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.dto.LoginReturn;
import com.fabRoadies.entity.User;
import com.fabRoadies.service.LoginService;


@CrossOrigin
@RestController  
public class LoginController {
	@Autowired
	private LoginService service;

    
	@GetMapping(value="/login/{email}/{password}",produces="application/json")
	public LoginReturn getUser(@PathVariable("email") String email,@PathVariable("password") String password) {
		
		Encoder encoder = Base64.getEncoder();
		String passwords = encoder.encodeToString(password.getBytes());
		
		User user= service.getByEmailPassword(email,passwords);
		System.out.println(user.getRoll().getRollid());
//		return user.getRoll().getRollid();
		LoginReturn a=new LoginReturn();
		a.setRoleId((user.getRoll().getRollid()));
		System.out.println(a.getRoleId());
		a.setUserId(user.getId());

		System.out.println(a.getUserId());

		return a;
//		return user;
		
	}

}

