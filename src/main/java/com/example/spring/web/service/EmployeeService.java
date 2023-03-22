package com.example.spring.web.service;

import java.util.List;

import com.example.spring.web.entity.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public Employee updateEmployee(Employee employee);

	public void deleteEmployeeById(int id);
}
