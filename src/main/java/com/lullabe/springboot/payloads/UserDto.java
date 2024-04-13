package com.lullabe.springboot.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	private int id;

	@NotNull
	@Size(min =4 , message = "Username must be min of 4 characters !!")
	private String name;

	@Email(message = "Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be at least 3 characters")
	private String password;
	
	@NotNull
	private String about;
}
