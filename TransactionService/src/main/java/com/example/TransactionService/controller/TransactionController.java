package com.example.TransactionService.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TransactionService.entity.Transaction;
import com.example.TransactionService.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // @GetMapping("/")
    // public void get(){
    //     System.out.println("transaction done");
    // }

    // Get transactions by user ID
    @GetMapping("/transactions/{login_id}")
    public ResponseEntity<List<Transaction>> list(@PathVariable long login_id) {
        List<Transaction> transactions = transactionService.getTransactionByLoginId(login_id);
        if(transactions.size() > 0){
            return ResponseEntity.ok(transactions);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    
    @PostMapping("/transactions")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        if(savedTransaction != null && savedTransaction.getId() != null){
            return new ResponseEntity<>(savedTransaction,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        
    }

    @PutMapping("/transactions")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.updateTransaction(transaction);
        if(savedTransaction != null && savedTransaction.getId() != null){
            return new ResponseEntity<>(savedTransaction,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        
    }

    // Delete a transaction by ID
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
