package com.example.CategoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CategoryService.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

