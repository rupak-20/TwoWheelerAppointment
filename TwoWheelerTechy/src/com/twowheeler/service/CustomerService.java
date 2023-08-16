package com.twowheeler.service;

import java.util.List;

import com.twowheeler.entity.Customer;

public interface CustomerService {
	public int insertCustomer(Customer customer);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int custId);
	public Customer viewSingleCustomer(int custId);
	public List<Customer> viewAllCustomer();
}
