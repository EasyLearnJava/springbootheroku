package com.easylearnjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easylearnjava.model.Customer;

@RestController
class CustomerResource {

	
	/*
	 * @GetMapping("/customers") List<Customer> all() { return new List<Customer>();
	 * }
	 * 
	 * @PostMapping("/customers") Customer newCustomer(@RequestBody Customer
	 * newCustomerModel) { return newCustomer(); }
	 * 
	 * // Single item
	 * 
	 * @GetMapping("/customers/{id}") Customer one(@PathVariable Long id) {
	 * 
	 * return repository.findById(id) .orElseThrow(() -> new
	 * CustomerNotFoundException(id)); }
	 * 
	 * @PutMapping("/customers/{id}") Customer replaceCustomerModel(@RequestBody
	 * Customer newCustomer, @PathVariable Long id) {
	 * 
	 * return repository.findById(id) .map(CustomerModel -> {
	 * Customer.setName(newCustomer.getName());
	 * Customer.setRole(newCustomer.getRole()); return repository.save(Customer); })
	 * .orElseGet(() -> { newCustomerModel.setId(id); return
	 * repository.save(newCustomerModel); }); }
	 * 
	 * @DeleteMapping("/customers/{id}") void deleteCustomerModel(@PathVariable Long
	 * id) {
	 * 
	 * }
	 */
}
