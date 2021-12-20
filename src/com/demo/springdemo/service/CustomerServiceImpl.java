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
	public List<Customer> getCustomers(int iSortField) {
		return lCustomerDao.getCustomers(iSortField);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer iCustomer) {
		
		lCustomerDao.saveCustomer(iCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int iId) {
		return lCustomerDao.getCustomer(iId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int iId) {
		lCustomerDao.deleteCustomer(iId);		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String iSearchName) {
		 return lCustomerDao.searchCustomers(iSearchName);
	}

}
