package com.lullabe.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lullabe.springboot.payloads.ApiResponse;
import com.lullabe.springboot.payloads.UserDto;
import com.lullabe.springboot.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// post
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto userDtoGet = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(userDtoGet, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {

		UserDto userDtoGet = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(userDtoGet);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		userService.deleteuser(userId);
		ResponseEntity<ApiResponse> responseEntity = new ResponseEntity<ApiResponse>(
				new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUserDtoList() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserDtoList(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}

}
