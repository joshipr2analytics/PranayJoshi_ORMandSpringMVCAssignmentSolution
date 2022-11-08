package com.greatlearning.customerRelationshipMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerRelationshipMgmt.service.CustomerServiceImplementation;
import com.greatlearning.customerRelationshipMgmt.enitity.Customer;

@Controller
public class CustomerRelationshipMgmtController {

	@Autowired
	CustomerServiceImplementation customerService;

	// Get All Customers
	@RequestMapping("/")
	public String customerslist(Model theModel) {
		// List of all customer
		List<Customer> allCustomers = customerService.allCustomers();

		// add to the spring model
		theModel.addAttribute("Customers", allCustomers);

		return "list-customers";
	}

	// Delete Customer
	@RequestMapping("/deleteDetails")
	public String deleteCustomer(@RequestParam("id") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/";
	}

	// load saved data and open registration details
	@RequestMapping("/updateDetails")
	public String updateCustomer(@RequestParam("id") int theId, Model theModel) {
		// List of all customer
		List<Customer> customerAll = customerService.findCustomer(theId);

		// Get Customer
		Customer c = customerAll.get(0);

		// add to the spring model
		theModel.addAttribute("Customer", c);
		return "Customer-Form";
	}

	// open new registration page
	@RequestMapping("/addCustomer")
	public String addNewCustomer(Model theModel) {
		// Add Customer Object
		Customer customer = new Customer();

		// add to the spring model
		theModel.addAttribute("Customer", customer);
		return "Customer-Form";
	}

	// save customer details
	@PostMapping("/saveDetails")
	public String saveRegistrationDetails(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer;
		if (id == 0)
			customer = new Customer(firstName, lastName, email);
		else {
			List<Customer> allcustomer = customerService.findCustomer(id);
			customer = allcustomer.get(0);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
}
