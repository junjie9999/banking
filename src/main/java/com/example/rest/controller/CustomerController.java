package com.example.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Customer;
import com.example.rest.dto.CustomerDTO;
import com.example.service.CustomerService;



@RestController

public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping("addCustomer")
	public CustomerDTO addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@GetMapping("/allCustomer")
	public List<CustomerDTO> getAllCustomer(){
		return service.getAllCustomer();
	}
	
	@PutMapping("/updateCustomer/{CustomerId}")
	public CustomerDTO updateCustomer(@PathVariable Long CustomerId, @RequestBody Customer customer) {
		return service.updateCustomer(CustomerId, customer);
	}
	
	@DeleteMapping("/deleteCustomer/{CustomerId}")
	public boolean deleteCustomer(@PathVariable long CustomerId) {
		return service.deleteCustomer(CustomerId);
	}
	
	@GetMapping("/customerById")
	public CustomerDTO readCustomerById(@PathParam("CustomerId") long CustomerId) {
		return service.readById(CustomerId);
	}
	
//	@GetMapping("/customerByName")
//	public List<CustomerDTO> readMusicianByName(@PathParam("name") String username){
//		return service.readByName(username);
//	}

}
