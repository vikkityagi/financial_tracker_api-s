package com.example.TransactionService.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type; // "income" or "expense"
    
    private BigDecimal amount;
    
    private String description;
    
    private LocalDate date;
    
    private long login_id; // Assuming userId is handled as a reference for now

    private long category_id;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public Transaction(){

    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    
    

    

    

    public long getLogin_id() {
        return login_id;
    }



    public void setLogin_id(long login_id) {
        this.login_id = login_id;
    }



    public long getCategory_id() {
        return category_id;
    }



    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }



    public LocalDateTime getCreated_at() {
        return created_at;
    }



    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }



    public LocalDateTime getUpdated_at() {
        return updated_at;
    }



    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    

    
}
