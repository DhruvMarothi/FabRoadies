package com.fabRoadies.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabRoadies.entity.Roles;

public interface RollRepo extends JpaRepository<Roles,Integer>  {

	
}
