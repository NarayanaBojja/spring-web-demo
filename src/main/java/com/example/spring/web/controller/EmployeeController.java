package com.example.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.web.entity.Employee;
import com.example.spring.web.modal.EmployeeResponse;
import com.example.spring.web.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody Employee employee) {
		var response = new EmployeeResponse();
		try {
			employeeService.saveEmployee(employee);
			response.setStatus(1);
		} catch (Exception e) {
			response.setStatus(-1);
			response.setErrorMessage("fail");
			return ResponseEntity.internalServerError().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int employeeId) {
		var response = new EmployeeResponse();
		try {
			Employee employee = employeeService.getEmployeeById(employeeId);
			response.setStatus(1);
			response.setData(List.of(employee));
		} catch (Exception e) {
			response.setStatus(-1);
			response.setErrorMessage("fail");
			return ResponseEntity.internalServerError().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/all")
	public ResponseEntity<EmployeeResponse> getAllEmployees() {
		var response = new EmployeeResponse();
		try {
			List<Employee> employees = employeeService.getAllEmployees();
			response.setStatus(1);
			response.setData(employees);
		} catch (Exception e) {
			response.setStatus(-1);
			response.setErrorMessage("fail");
			return ResponseEntity.internalServerError().body(response);
		}
		return ResponseEntity.ok(response);
	}
	@PutMapping
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody Employee employee) {
		var response = new EmployeeResponse();
		try {
			employeeService.updateEmployee(employee);
			response.setStatus(1);
		} catch (Exception e) {
			response.setStatus(-1);
			response.setErrorMessage("fail");
			return ResponseEntity.internalServerError().body(response);
		}
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<EmployeeResponse> deleteEmployeeById(@PathVariable int employeeId) {
		var response = new EmployeeResponse();
		try {
			employeeService.deleteEmployeeById(employeeId);
			response.setStatus(1);
		} catch (Exception e) {
			response.setStatus(-1);
			response.setErrorMessage("fail");
			return ResponseEntity.internalServerError().body(response);
		}
		return ResponseEntity.ok(response);
	}
}
