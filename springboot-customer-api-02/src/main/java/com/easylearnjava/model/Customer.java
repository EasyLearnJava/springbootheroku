package com.easylearnjava.model;

import lombok.Data;

@Data
public class Customer {
	
	private int id;
	private String name;
	private String role;
	private String emailId;
	private String password;
	
	public Customer(String name, String role, String emailId, String password) {
		super();
		this.name = name;
		this.role = role;
		this.emailId = emailId;
		this.password = password;
	}	

}
