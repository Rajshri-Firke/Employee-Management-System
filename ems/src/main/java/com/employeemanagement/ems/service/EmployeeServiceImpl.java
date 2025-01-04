package com.employeemanagement.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.ems.dto.EmployeeDto;
import com.employeemanagement.ems.entity.Employee;
import com.employeemanagement.ems.mapper.EmployeeMapper;
import com.employeemanagement.ems.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRespository;
	
	@Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

	
	public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
		Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRespository.save(newEmployee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
}
