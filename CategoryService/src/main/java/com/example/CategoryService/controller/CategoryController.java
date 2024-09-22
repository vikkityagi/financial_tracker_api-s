package com.example.CategoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.CategoryService.entity.Category;
import com.example.CategoryService.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/categories/{login_id}")
    public ResponseEntity<List<Category>> list(@PathVariable Long login_id) {
        List<Category> categoryList = categoryService.getAllCategories(login_id);
        if(categoryList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        try{
            Category categoryRet = categoryService.createCategory(category);
            if(categoryRet.getId() != null){
                return new ResponseEntity<>(categoryRet, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category categoryRet = this.categoryService.updateCategory(category);
        if(categoryRet.getId() != null){
            return new ResponseEntity<>(categoryRet, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
