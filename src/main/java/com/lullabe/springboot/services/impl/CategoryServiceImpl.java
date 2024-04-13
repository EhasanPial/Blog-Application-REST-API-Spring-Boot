package com.lullabe.springboot.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lullabe.springboot.entity.Category;
import com.lullabe.springboot.exceptions.ResourceNotFoundException;
import com.lullabe.springboot.payloads.CategoryDto;
import com.lullabe.springboot.repository.CategoryRepo;
import com.lullabe.springboot.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = modelMapper.map(categoryDto, Category.class);
		Category addedCat = categoryRepo.save(cat);
		 
		return modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto catDto, Integer catId) {
		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", catId));
		cat.setCategoryTitle(catDto.getCategoryTitle());
		cat.setCategoryDescription(catDto.getCategoryDescription());

		Category updateCat = this.categoryRepo.save(cat);

		return this.modelMapper.map(updateCat, CategoryDto.class);

	}

	@Override
	public CategoryDto getCategoryById(Integer catId) {
		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", catId));
		return modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		List<Category> categories = categoryRepo.findAll();
		
		List<CategoryDto> listDto = categories.stream().map(cat -> modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return listDto;
	}

	@Override
	public void deleteCategory(Integer id) {
		Category cat = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", id));
		categoryRepo.delete(cat);
	}

}
