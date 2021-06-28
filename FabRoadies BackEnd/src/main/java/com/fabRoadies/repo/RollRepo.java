package com.fabRoadies.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabRoadies.entity.Roles;

/** 
 * @author Pratik 
 * @version 1.0
 */
public interface RollRepo extends JpaRepository<Roles,Integer>  {

	
}
