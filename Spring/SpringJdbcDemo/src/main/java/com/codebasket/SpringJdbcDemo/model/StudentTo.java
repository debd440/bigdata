package com.codebasket.SpringJdbcDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
@NoArgsConstructor
public class StudentTo {

	private int id;
	private String name;
	private String city;
}
