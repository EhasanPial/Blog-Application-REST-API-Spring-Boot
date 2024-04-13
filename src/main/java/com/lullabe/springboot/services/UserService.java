package com.lullabe.springboot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lullabe.springboot.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteuser(Integer id);

}
