package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.User;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepoSpecific{

	
	
}
