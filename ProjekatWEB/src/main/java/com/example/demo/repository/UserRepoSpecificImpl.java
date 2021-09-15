package com.example.demo.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.User;

@Repository
@Transactional
public class UserRepoSpecificImpl implements UserRepoSpecific{

	

}
