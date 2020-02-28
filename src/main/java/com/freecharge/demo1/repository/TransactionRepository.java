package com.freecharge.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.freecharge.demo1.model.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long>
{

}
