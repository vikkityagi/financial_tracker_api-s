package com.example.CategoryService.service;


import java.util.List;

import com.example.CategoryService.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories(long login_id);
    Category getCategoryById(Long id);
    Category createCategory(Category category) throws Exception;
    Category updateCategory(Category category);
    void deleteCategory(Long id);
}
