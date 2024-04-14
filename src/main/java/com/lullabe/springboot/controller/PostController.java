package com.lullabe.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lullabe.springboot.payloads.PostDto;
import com.lullabe.springboot.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	// post
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createCategory(@Valid @RequestBody PostDto PostDto, @PathVariable Integer categoryId,
			@PathVariable Integer userId) {
		PostDto PostDtoGet = postService.createPost(PostDto, userId, categoryId);
		return new ResponseEntity<PostDto>(PostDtoGet, HttpStatus.CREATED);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer categoryId) {
		List<PostDto> posts = postService.getPostsByUser(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK) ;

	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer userId) {
		List<PostDto> posts = postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK) ;

	}

}
