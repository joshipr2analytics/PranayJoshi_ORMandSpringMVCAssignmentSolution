package com.greatlearning.customerRelationshipMgmt.service;

import java.util.List;

import com.greatlearning.customerRelationshipMgmt.enitity.Customer;

public interface ICustomerService {

	public List<Customer> allCustomers();

	public List<Customer> findCustomer(int id);

	public void deleteCustomer(int id);

	public void saveCustomer(Customer c);
}
