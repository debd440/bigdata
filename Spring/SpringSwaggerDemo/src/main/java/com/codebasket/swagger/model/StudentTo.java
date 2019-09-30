package com.codebasket.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
public class StudentTo {

    @ApiModelProperty(notes = "Describes Student Name")
	private String name;
    @ApiModelProperty(notes = "Describes Student City")
	private String city;
}
