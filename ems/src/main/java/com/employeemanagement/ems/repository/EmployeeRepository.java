package com.employeemanagement.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.ems.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
