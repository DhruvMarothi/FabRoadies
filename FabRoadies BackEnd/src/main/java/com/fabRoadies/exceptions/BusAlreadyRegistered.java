package com.fabRoadies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dhruv Marothi
 * @version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusAlreadyRegistered extends RuntimeException{
	public BusAlreadyRegistered(String message) {
        super(message);
	}

}
