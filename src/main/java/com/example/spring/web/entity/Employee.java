package com.example.spring.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@Column
	private int id;
	@Column
	private String firstName;
	@Column
	private String lastName;

}
