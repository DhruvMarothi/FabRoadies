package com.fabRoadies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabRoadies.entity.Passenger;

/**
 * Reperesents Passenger Repository
 * @author Dhruv Marothi
 * @version 1.0
 */
public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}