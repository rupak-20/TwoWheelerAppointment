package com.twowheeler.dao;

import java.util.List;

import com.twowheeler.entity.Customer;

public interface ICustomerDAO {
	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(int custId);
	Customer viewCustomer(int custId);
	List<Customer> viewCustomers();
}