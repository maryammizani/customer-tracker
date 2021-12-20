package com.demo.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springdemo.entity.Customer;
import com.demo.springdemo.util.SortUtils;

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
	public List<Customer> getCustomers(int iSortField) {
		
		// Get the current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
		
		// determine sort field
		String lFieldName = null;
		
		switch (iSortField) {
			case SortUtils.FIRST_NAME: 
				lFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				lFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				lFieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by lastName
				lFieldName = "lastName";
		}
		
		// create a query  
		String lQueryString = "from Customer order by " + lFieldName;
		Query<Customer> lQuery = lSession.createQuery(lQueryString, Customer.class);
						
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

	@Override
	public List<Customer> searchCustomers(String iSearchName) {
		// Get Current hibernate session
		Session lSession = sessionFactory.getCurrentSession();
				
		Query lQuery = null;
        
        // only search by name if iSearchName is not empty
        if (iSearchName != null && iSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
        	lQuery =lSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
        	lQuery.setParameter("theName", "%" + iSearchName.toLowerCase() + "%");
        }
        else {
            // iSearchName is empty ... so just get all customers
        	lQuery =lSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> lCustomers = lQuery.getResultList();
                
        // return the results        
        return lCustomers;		
	}

}
