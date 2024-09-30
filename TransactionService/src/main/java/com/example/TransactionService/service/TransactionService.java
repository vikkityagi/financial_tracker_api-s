package com.example.TransactionService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransactionService.entity.Transaction;
import com.example.TransactionService.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    

    public Transaction saveTransaction(Transaction transaction) {
        transaction.setCreated_at(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionByLoginId(long login_id) {
        // TODO Auto-generated method stub
        return this.transactionRepository.findByLoginId(login_id);
    }

    public Transaction updateTransaction(Transaction transaction) {
        // TODO Auto-generated method stub
        Transaction transactionObj = this.transactionRepository.findById(transaction.getId()).get();
        transactionObj.setDescription(transaction.getDescription());
        transactionObj.setAmount(transaction.getAmount());
        transactionObj.setDate(transaction.getDate());
        transactionObj.setCategory_id(transaction.getCategory_id());
        transactionObj.setType(transaction.getType());
        transactionObj.setUpdated_at(LocalDateTime.now());
        return this.transactionRepository.save(transactionObj);
    }
}