package com.easylearnjava.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easylearnjava.dao.CustomerRepository;
import com.easylearnjava.model.Customer;
import com.easylearnjava.util.CustomerNotFoundException;

@RestController
public class CustomerResource {

	
	private final CustomerRepository repository;

	CustomerResource(CustomerRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	// tag::get-aggregate-root[]
	@GetMapping("/customers")
	Resources<Resource<Customer>> all() {

		List<Resource<Customer>> customers = repository.findAll().stream()
			.map(customer -> new Resource<>(customer,
				linkTo(methodOn(CustomerResource.class).one(customer.getId())).withSelfRel(),
				linkTo(methodOn(CustomerResource.class).all()).withRel("customers")))
			.collect(Collectors.toList());
		
		return new Resources<>(customers,
			linkTo(methodOn(CustomerResource.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return repository.save(newCustomer);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/customers/{id}")
	Resource<Customer> one(@PathVariable Long id) {
		
		Customer customer = repository.findById(id)
			.orElseThrow(() -> new CustomerNotFoundException(id));
		
		return new Resource<>(customer,
			linkTo(methodOn(CustomerResource.class).one(id)).withSelfRel(),
			linkTo(methodOn(CustomerResource.class).all()).withRel("customers"));
	}
	// end::get-single-item[]

	@PutMapping("/customers/{id}")
	Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(customer -> {
				customer.setName(newCustomer.getName());
				customer.setRole(newCustomer.getRole());
				return repository.save(customer);
			})
			.orElseGet(() -> {
				newCustomer.setId(id);
				return repository.save(newCustomer);
			});
	}

	@DeleteMapping("/customers/{id}")
	void deleteCustomer(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
