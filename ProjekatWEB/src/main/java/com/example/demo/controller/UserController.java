package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.UserRepository;

import models.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	private String saveUser(User u, Errors e, Model m, HttpServletRequest request) {
		if (e.hasErrors()) {
			return "error/error.jsp";
		} else {
			ur.save(u);
		}
		request.getSession().setAttribute("user", u);
		m.addAttribute("message", "User successfuly registered");
		return "menu/UserMenu";
	}
	
}
