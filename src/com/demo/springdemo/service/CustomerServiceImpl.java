package com.demo.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springdemo.dao.CustomerDAO;
import com.demo.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Need to inject customer DAO
	@Autowired
	private CustomerDAO lCustomerDao;	
	
	// Transactional automatically begins and ends a transaction for the Hibernate code
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return lCustomerDao.getCustomers();
	}

}
