package com.lullabe.springboot.payloads;

import java.util.Date;

import com.lullabe.springboot.entity.Category;
import com.lullabe.springboot.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {
	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	private Date addedDate;

	private CategoryDto category;

	private UserDto user;
}
