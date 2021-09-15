package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.FoodItem;

@Repository
@Transactional
public class FoodMenuRepoSpecificImpl implements FoodMenuRepoSpecific{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<FoodItem> getAllFoodItems() {
		List<FoodItem> menu = em.createQuery("SELECT fi FROM FoodItem fi").getResultList();
		return menu;
	}

}
