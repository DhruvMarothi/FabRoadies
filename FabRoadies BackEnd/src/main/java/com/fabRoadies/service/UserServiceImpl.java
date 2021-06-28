package com.fabRoadies.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Roles;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.RollRepo;
import com.fabRoadies.repo.UserRepo;


/**
 * @author Dhruv and Pratik and Shailendra
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private RollRepo rollrepo;

	@Override
	public void addUser(User user,int roll) {
		Roles rolls =getRoll(roll);
		user.setRoll(rolls);
	    repo.save(user);
	}
	
	public Roles getRoll(int roll)
	{
		return rollrepo.findById(roll).get();
	}
	
	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public User getByCode(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void removeUser(int code) {
		repo.deleteById(code);
	}

	@Override
	public void updateUser(User user) {
		if(repo.getById(user.getId())!=null) {
			Roles rolls = new Roles();
			rolls.setRollid(2);
			rolls.setUsertype("User");
			user.setRoll(rolls);
			repo.save(user);
		}
		else {
			System.out.println("User does not exist");
		}		
		repo.save(user);
		
	}
	@Override
	public int getUserIdByEmail(String email) {
		return repo.findOneByEmail(email).getId();
	}	
}




	



	

	
	


