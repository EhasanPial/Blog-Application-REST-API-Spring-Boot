package com.lullabe.springboot.services;

import java.util.List;

import com.lullabe.springboot.payloads.CategoryDto;

public interface CategoryService {
	CategoryDto createCategory(CategoryDto Category);

	CategoryDto updateCategory(CategoryDto Category, Integer CategoryId);

	CategoryDto getCategoryById(Integer CategoryId);

	List<CategoryDto> getAllCategorys();

	void deleteCategory(Integer id);
}
 