package com.lullabe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lullabe.springboot.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
}
