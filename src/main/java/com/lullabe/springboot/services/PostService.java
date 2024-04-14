package com.lullabe.springboot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lullabe.springboot.payloads.PostDto;

public interface PostService {
	PostDto createPost(PostDto Post, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto Post, Integer postId);

	PostDto getPostById(Integer postId);

	List<PostDto> getAllPosts();

	void deletePost(Integer id);

	List<PostDto> getPostsByCategory(Integer categoryId);

	List<PostDto> getPostsByUser(Integer userId);

	List<PostDto> searchPosts(String keywords);

}
