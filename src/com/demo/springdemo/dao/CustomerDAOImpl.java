package com.demo.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springdemo.entity.Customer;

// Add @Repository so that Spring can do component scan, find this repository
// Also to handle the exception translation for us
// Remember @Repository is always applied to DAO implementations
@Repository 
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory so DAO can use it to talk to DB
	@Autowired
	private SessionFactory sessionFactory;	
	
	// Transactional is moved to the Service Layer
	@Override
	public List<Customer> getCustomers() {
		
		// Get the current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
		
		// Create a Query .. sort by last name
		Query<Customer> lQuery = lSession.createQuery("from Customer order by lastName", Customer.class);
				
		// Execute query and get result list
		List<Customer> lCustomers = lQuery.getResultList();
		
		// Return the results
		return lCustomers;
	}

	@Override
	public void saveCustomer(Customer iCustomer) {
		
		// Get Current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
		
		// Save the customer
		lSession.saveOrUpdate(iCustomer);
		
	}

	@Override
	public Customer getCustomer(int iId) {
		// Get Current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
		
		// Retrieve from DB using the primary key
		Customer lCustomer = lSession.get(Customer.class, iId);
		return lCustomer;
	}

	@Override
	public void deleteCustomer(int iId) {
		// Get Current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
		
		// Delete Object using primary key
		Query<Customer> lQuery = lSession.createQuery("delete from Customer where id=:customerId");
		lQuery.setParameter("customerId", iId);
		lQuery.executeUpdate();
	}

}
