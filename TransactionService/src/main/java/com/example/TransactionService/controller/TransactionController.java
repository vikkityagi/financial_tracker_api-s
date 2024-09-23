package com.example.TransactionService.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TransactionService.entity.Transaction;
import com.example.TransactionService.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // @GetMapping("/")
    // public void get(){
    //     System.out.println("transaction done");
    // }

    // // Get transactions by user ID
    // @GetMapping("/user/{userId}")
    // public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
    //     List<Transaction> transactions = transactionService.getTransactionsByUser(userId);
    //     return ResponseEntity.ok(transactions);
    // }

    // Add a new transaction
    @PostMapping("/transactions")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        if(savedTransaction != null && savedTransaction.getId() != null){
            return new ResponseEntity<>(savedTransaction,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        
    }

    // // Delete a transaction by ID
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
    //     transactionService.deleteTransaction(id);
    //     return ResponseEntity.noContent().build();
    // }
}
