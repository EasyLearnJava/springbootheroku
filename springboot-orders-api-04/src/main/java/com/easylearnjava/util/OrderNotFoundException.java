package com.easylearnjava.util;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}
}