package com.easylearnjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easylearnjava.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
