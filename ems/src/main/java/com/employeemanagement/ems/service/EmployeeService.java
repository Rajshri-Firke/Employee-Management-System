package com.employeemanagement.ems.service;

import java.util.List;

import com.employeemanagement.ems.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto createNewEmployee(EmployeeDto employeeDto);

	public List<EmployeeDto> getAllEmployees();

	public EmployeeDto getEmployeeById(Long employeeId);

	public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);

	public void deleteEmployeeById(Long employeeId);
}
