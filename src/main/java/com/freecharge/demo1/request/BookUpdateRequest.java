package com.freecharge.demo1.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookUpdateRequest
{
	@NotNull
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String authorName;
	@NotNull
	private int bookCount;
}
