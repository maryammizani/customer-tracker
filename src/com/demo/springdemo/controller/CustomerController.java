package com.demo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springdemo.dao.CustomerDAO;
import com.demo.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the customer DAO
	// With Autowired spring is going to scan for a component that implements the CustomerDAO interface.
	// Because of @Repository we used in CustomerDAOImpl, it's able to find it
	// and make it available and inject it.
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model iModel) {
		
		// Get customers from the DAO
		List<Customer> lCustomers = customerDAO.getCustomers();
		
		// Add the customers to the model
		iModel.addAttribute("customers",lCustomers);
		
		// Create a list-customers.jsp page under WEB-INF/view
		return "list-customers";
	}
}
