package com.employeemanagement.ems.mapper;

import com.employeemanagement.ems.dto.EmployeeDto;
import com.employeemanagement.ems.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstname(),
				employee.getLastname(),
				employee.getEmail()
		);
				
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstname(),
				employeeDto.getLastname(),
				employeeDto.getEmail()		
		);
				
	}
}
