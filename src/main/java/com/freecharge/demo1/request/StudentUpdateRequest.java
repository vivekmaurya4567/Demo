package com.freecharge.demo1.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentUpdateRequest 
{
	@NotNull
	private long id; 
	@NotBlank
	private String name;
	@NotBlank
	private String degree;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date dob;	
}
