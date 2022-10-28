package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "customer does not exist with that ID")
public class CustomerNotFoundException extends EntityNotFoundException{
	public CustomerNotFoundException() {}
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
