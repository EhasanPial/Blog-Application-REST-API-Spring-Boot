package com.lullabe.springboot.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lullabe.springboot.entity.User;
import com.lullabe.springboot.payloads.UserDto;
import com.lullabe.springboot.repository.UserRepo;
import com.lullabe.springboot.services.UserService;
import com.lullabe.springboot.exceptions.*;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		user = userRepo.save(user);
		return userToDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		user = userRepo.save(user);
		return userToDto(user);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();

		List<UserDto> userDtos = users.stream().map((user) -> userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteuser(Integer id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		userRepo.delete(user);
	}

	private User dtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);

		return user;
	}

	private UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
//		u	serDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());

		return userDto;
	}

}
