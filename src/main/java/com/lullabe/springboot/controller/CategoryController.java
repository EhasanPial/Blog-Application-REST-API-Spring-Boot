package com.lullabe.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lullabe.springboot.payloads.ApiResponse;
import com.lullabe.springboot.payloads.CategoryDto;
import com.lullabe.springboot.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	// post
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto CategoryDtoGet = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(CategoryDtoGet, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto CategoryDto, @PathVariable Integer categoryId) {

		CategoryDto CategoryDtoGet = categoryService.updateCategory(CategoryDto, categoryId);
		return ResponseEntity.ok(CategoryDtoGet);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
		categoryService.deleteCategory(categoryId);
		ResponseEntity<ApiResponse> responseEntity = new ResponseEntity<ApiResponse>(
				new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategoryDtoList() {
		return ResponseEntity.ok(categoryService.getAllCategorys());
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryDtoList(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

}
