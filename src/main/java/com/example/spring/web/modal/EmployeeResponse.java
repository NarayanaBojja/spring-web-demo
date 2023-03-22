package com.example.spring.web.modal;

import java.util.ArrayList;
import java.util.List;

import com.example.spring.web.entity.Employee;

import lombok.Data;

@Data
public class EmployeeResponse extends EmployeeBaseResponse {
	private List<Employee> data = new ArrayList<>();
}
