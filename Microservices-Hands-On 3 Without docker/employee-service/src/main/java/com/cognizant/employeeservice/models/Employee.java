package com.cognizant.employeeservice.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@NotNull
	private int emp_id;
	
	@NotNull
	@Size(min = 1, max = 30, message = "Employee name should not null and less than 30 characters")
    private String name;
	
	@NotNull
    private double salary;
    
	@NotNull
	private boolean permanent;
    
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dateOfBirth;
}
