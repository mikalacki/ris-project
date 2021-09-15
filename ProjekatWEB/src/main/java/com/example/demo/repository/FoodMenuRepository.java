package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.FoodItem;


public interface FoodMenuRepository extends JpaRepository<List<FoodItem>, Integer>, FoodMenuRepoSpecific{

	
	
}
