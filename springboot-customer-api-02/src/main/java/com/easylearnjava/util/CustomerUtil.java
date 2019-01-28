package com.easylearnjava.util;

import com.easylearnjava.model.Customer;

public class CustomerUtil {
	
	public static Customer createEmployee() {
		return new Customer("raghu", "admin", "raghu@test.com", "secret");
	}

}
