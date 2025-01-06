package com.employeemanagement.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.ems.dto.EmployeeDto;
import com.employeemanagement.ems.entity.Employee;
import com.employeemanagement.ems.exception.ResourceNotFoundException;
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


	
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> allEmployees = employeeRespository.findAll();
		return allEmployees.stream().map((e) ->EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}



	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee ID requested doesn't exist"));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	
	public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee ID requested doesn't exist"));
		employee.setFirstname(employeeDto.getFirstname());
		employee.setLastname(employeeDto.getLastname());
		employee.setEmail(employeeDto.getEmail());
		employeeRespository.save(employee); 
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	
	public void deleteEmployeeById(Long id) {
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NO ID"));
		employeeRespository.deleteById(id); 
		
	}
}
