package com.humber.j2ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.humber.j2ee.model.exam.Category;
import com.humber.j2ee.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Add Category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category category1 = this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	
	//GetCategory
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId)
	{
		return categoryService.getCategory(categoryId);
	}
	
	
	//All Get Categories
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//Update Category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
	}
	
	//Delete Category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId)
	{
		this.categoryService.deleteCategory(categoryId);
	}
	
	

}
