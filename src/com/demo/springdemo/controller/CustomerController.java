package com.demo.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")
	public String listCustomer(Model iModel) {
		
		// Create a list-customers.jsp page under WEB-INF/view
		return "list-customers";
	}
}
