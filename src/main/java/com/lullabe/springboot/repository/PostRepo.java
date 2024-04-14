package com.lullabe.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lullabe.springboot.entity.Category;
import com.lullabe.springboot.entity.Post;
import com.lullabe.springboot.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

	
}
