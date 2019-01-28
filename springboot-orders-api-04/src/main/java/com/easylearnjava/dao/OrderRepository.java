package com.easylearnjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easylearnjava.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
