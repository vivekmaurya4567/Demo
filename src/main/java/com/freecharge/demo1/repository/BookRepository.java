package com.freecharge.demo1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.freecharge.demo1.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>
{

}
