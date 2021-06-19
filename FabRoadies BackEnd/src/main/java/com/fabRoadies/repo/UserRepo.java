package com.fabRoadies.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>
	{  
	User findOneByEmail(String email);
	
	@Query("from User where email=:uemail and password=:upassword")
	User getByEmailPassword(String uemail,String upassword);
	
	

	}
