package com.lullabe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lullabe.springboot.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
