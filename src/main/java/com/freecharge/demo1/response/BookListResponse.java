package com.freecharge.demo1.response;

import java.util.List;

import com.freecharge.demo1.model.BookEntity;

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
public class BookListResponse
{
	public List<BookEntity> arr;
	
}
