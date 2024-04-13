package com.lullabe.springboot.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank(message = "Category title is required")
	@Size(min = 4, message = "Min size of category title is 4")
	private String categoryTitle;
	
	@Size(min = 4, message = "Max size of category title is 4")
	private String categoryDescription;

}
