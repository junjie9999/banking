package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomerNotFoundException;
import com.example.persistence.domain.Customer;
import com.example.persistence.repository.CustomerRepository;
import com.example.rest.dto.CustomerDTO;



@Service

public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private CustomerDTO mapToDTO(Customer customer) {
		return this.mapper.map(customer, CustomerDTO.class);
	}
	
	public CustomerDTO addCustomer(Customer customer){
		Customer saved = this.repo.save(customer);
		return this.mapToDTO(saved);
	}
	
	public List<CustomerDTO> getAllCustomer(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public CustomerDTO updateCustomer(long CustomerId, Customer customer) {
		Optional<Customer> c = Optional.of(this.repo.findById(CustomerId).orElseThrow(CustomerNotFoundException::new));
		Customer existing = c.get();
		
		existing.setUsername(customer.getUsername());
		existing.setEmail(customer.getEmail());
		existing.setPassword(customer.getPassword());
		existing.setPhoneNumber(customer.getPhoneNumber());
		existing.setAccountType(customer.getAccountType());
		existing.setAccount(customer.getAccount());
		
		Customer updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteCustomer(long CustomerId) {
		this.repo.findById(CustomerId).orElseThrow(CustomerNotFoundException::new);
		this.repo.deleteById(CustomerId);
		boolean exists = this.repo.existsById(CustomerId);
		return !exists;
	}
	
	public CustomerDTO readById(long CustomerId) {
		Customer found =  this.repo.findById(CustomerId).orElseThrow(CustomerNotFoundException::new);
		return this.mapToDTO(found);
	}
	
//	public List<CustomerDTO> readByName(String Username){
//		List<Customer> found = this.repo.customerByName(Username).orElseThrow(CustomerNotFoundException::new);
//		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
//	}

}
