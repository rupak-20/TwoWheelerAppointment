package com.twowheeler.controller;

import com.twowheeler.entity.Customer;
import com.twowheeler.service.CustomerService;
import com.twowheeler.service.CustomerServiceImpl;
import java.util.*;

public class CustomerController {

	private CustomerService customerService;

	public CustomerController() {
		customerService = new CustomerServiceImpl();
	}
	
	public void insertCustomer(Customer customer) {
		int status = customerService.insertCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void modifyCustomer(Customer customer) {
		int status = customerService.updateCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record modified successfully.");
		}else {
			System.out.println("Record couldn't be modified");
		}
	}
	
	public void deleteCustomer(int custId) {
		int status = customerService.deleteCustomer(custId);
		
		if(status > 0) {
			System.out.println("Record successfully deleted.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Customer viewSingleCustomer(int custId) {
		Customer customer = customerService.viewSingleCustomer(custId);
		return customer;
	}
	
	public List<Customer> viewAllCustomer() {
		return customerService.viewAllCustomer();
	}
}
