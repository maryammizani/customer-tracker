package com.demo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springdemo.dao.CustomerDAO;
import com.demo.springdemo.entity.Customer;
import com.demo.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the customerService
	// With Autowired spring is going to scan for a component that implements the CustomerService interface.
	// Because of @Service we used in CustomerServiceImpl, it's able to find it
	// and make it available and inject it.
	@Autowired
	private CustomerService lCustomerService;
	
	@GetMapping("/list")
	public String listCustomer(Model iModel) {
		
		// Get customers from the Service
		List<Customer> lCustomers = lCustomerService.getCustomers();
		
		// Add the customers to the model
		iModel.addAttribute("customers",lCustomers);
		
		// Create a list-customers.jsp page under WEB-INF/view
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model iModel) {
		
		// Create Model Attribute to bind the form data
		Customer lCustomer = new Customer();
		iModel.addAttribute("customer", lCustomer);
		
		return "customer-form";  // Returns the jsp file called customer-form
	}
	
	@PostMapping("/saveCustomer") // <form:form action="saveCustomer" modelAttribute="customer" method="POST">
	public String saveCustomer(@ModelAttribute("customer") Customer iCustomer) {
		
		// Save the Customer using our service
		lCustomerService.saveCustomer(iCustomer);
		
		return "redirect:/customer/list"; 
	}
	
	//	<c:url var="updateLink" value="/customer/showFormForUpdate">
	//		<c:param name="customerId" value="${tempCustomer.id}" />
	// <form:form action="saveCustomer" modelAttribute="customer" method="POST">
	@GetMapping("/showFormForUpdate") 
	public String showFormForUpdate(@RequestParam("customerId") int iId, Model iModel) {
		
		// get the customer from our service
		Customer lCustomer = lCustomerService.getCustomer(iId);

		// Set Customer as a model attribute to pre-populate the form
		iModel.addAttribute("customer", lCustomer);
		
		// Send over to our form
		return "customer-form"; 
	}
	
	
	// <c:url var="deleteLink" value="/customer/delete">
	//	<c:param name="customerId" value="${tempCustomer.id}" />
	// </c:url>
	@GetMapping("/delete") 
	public String deleteCustomer(@RequestParam("customerId") int iId, Model iModel) {
		
		// Delete the Customer
		lCustomerService.deleteCustomer(iId);
		return "redirect:/customer/list";  
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String iSearchName, Model iModel) {
        // search customers from the service
        List<Customer> lCustomers = lCustomerService.searchCustomers(iSearchName);
                
        // add the customers to the model
        iModel.addAttribute("customers", lCustomers);
        return "list-customers";        
    }
}
