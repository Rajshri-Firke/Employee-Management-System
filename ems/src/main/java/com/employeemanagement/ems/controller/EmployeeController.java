package com.employeemanagement.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.ems.dto.EmployeeDto;
import com.employeemanagement.ems.service.EmployeeService;
import com.employeemanagement.ems.service.EmployeeServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;
	
	 @Autowired  // Constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee  = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<> (savedEmployee, HttpStatus.CREATED);
	}
}
