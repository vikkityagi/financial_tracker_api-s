package com.example.TransactionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TransactionService.entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value="select *from transaction where login_id = ?1",nativeQuery = true)
    List<Transaction> findByLoginId(long login_id);
    
    
}