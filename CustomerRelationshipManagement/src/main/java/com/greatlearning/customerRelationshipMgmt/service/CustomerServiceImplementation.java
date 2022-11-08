package com.greatlearning.customerRelationshipMgmt.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customerRelationshipMgmt.enitity.Customer;

@Repository
public class CustomerServiceImplementation implements ICustomerService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	// All Customers list
	@Transactional
	public List<Customer> allCustomers() {

		// Begin Transaction
		Transaction tx = session.beginTransaction();

		// Fetch List of Customer
		List<Customer> allCustomer = session.createQuery("from Customer").list();

		// Transaction Commit
		tx.commit();
		return allCustomer;
	}

	// Find Selected Customers list
	@Transactional
	public List<Customer> findCustomer(int id) {

		// Begin Transaction
		Transaction tx = session.beginTransaction();

		// Fetch List of Customer
		List<Customer> allCustomer = session.createQuery("from Customer where id=" + id).list();

		// Transaction Commit
		tx.commit();
		return allCustomer;
	}

	// Delete Customer
	@Transactional
	public void deleteCustomer(int id) {

		// Begin Transaction
		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer = session.get(Customer.class, id);

		// delete record
		session.delete(customer);

		// Transaction Commit
		tx.commit();

	}

	// save customer details from database
	@Transactional
	public void saveCustomer(Customer c) {

		// Begin Transaction
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(c);

		// Transaction Commit
		tx.commit();

	}

}
