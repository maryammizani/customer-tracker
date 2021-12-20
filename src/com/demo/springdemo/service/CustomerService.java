package com.demo.springdemo.service;

import java.util.List;

import com.demo.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int iSortField);

	public void saveCustomer(Customer iCustomer);

	public Customer getCustomer(int iId);

	public void deleteCustomer(int iId);

	public List<Customer> searchCustomers(String iSearchName);

}
