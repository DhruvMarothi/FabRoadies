package com.fabRoadies.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.dto.LoginReturn;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.UserRepo;
import com.fabRoadies.service.UserService;
import com.fabRoadies.utils.Emailsend;


/** 
 * @author Shailendra 
 * @version 1.0
 */
@CrossOrigin
@RestController  
public class UserController 
{
	@Autowired
	private UserService service;
    @Autowired
    private UserRepo userRepository;
	@Autowired
	private Emailsend emailsend;
	
	@PostMapping(value="/add/{roll}",consumes="application/json")
	public void addUser(@RequestBody User user,@PathVariable("roll") int roll)
	{
		 User foundUser = userRepository.findOneByEmail(user.getEmail());
	        if (foundUser != null) {
	            throw new RuntimeException();
	        }  

	        
		service.addUser(user,roll);
		//System.out.print(service.getByCode(user.getId()).getPassword());
		String msg="Hello Dear "+user.getName()+",\n"
			    	+ "We are pleased to inform you that you are successfully registered with us.\n"
			    
			    	+"user id : "+user.getId()+"\n";
		
				
		emailsend.sendSimpleEmail(user.getEmail(),msg, "welcome");	
		
	}
	
	/////////
	
	@GetMapping(value="/user/{code}",produces="application/json")
	public User getUser(@PathVariable("code") int code) {
		return service.getByCode(code);
	}
	
	@GetMapping(value="/userid/{email}",produces="application/json")
	public LoginReturn getUserIdByEmail(@PathVariable("email") String email) {
		LoginReturn role = new LoginReturn();
		role.setRoleId(2);
		role.setUserId(service.getUserIdByEmail(email));
		return role;
	}

	@GetMapping(value="/users",produces="application/json")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	@DeleteMapping(value="del/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		service.removeUser(id);
	}
	
	@PutMapping(value="/user/update")
	public User updateUser(@RequestBody User user)
	{
		service.updateUser(user);
		return user;
	}
}


	


	
