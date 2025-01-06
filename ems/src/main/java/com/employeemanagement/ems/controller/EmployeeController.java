package com.employeemanagement.ems.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long employeeId){
		EmployeeDto employeeById = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
		EmployeeDto employeeById = employeeService.updateEmployeeById(employeeId, employeeDto);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}
