package com.codebasket.SpringAopTutorials.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
public class Employee {
	
	private String empId;
	private String name;
}
