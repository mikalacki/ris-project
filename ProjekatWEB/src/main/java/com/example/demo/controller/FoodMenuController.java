package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.FoodMenuRepository;

import models.FoodItem;

@Controller
@RequestMapping(value = "/foodMenu")
public class FoodMenuController {

	@Autowired
	FoodMenuRepository fmr;
	
	@RequestMapping(value = "/showFoodMenu", method = RequestMethod.GET)
	private List<FoodItem> showFoodMenu(List<FoodItem> menu, Errors e, Model m, HttpServletRequest request) {
		if (e.hasErrors()) {
			return null;
		} 
		request.getSession().setAttribute("menu", menu);
		return menu;
	}
	
}
