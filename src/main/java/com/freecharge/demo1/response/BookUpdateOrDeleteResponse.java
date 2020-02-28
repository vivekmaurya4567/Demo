package com.freecharge.demo1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookUpdateOrDeleteResponse 
{
	 String result; 
		private String name;
	    private long id;
}
