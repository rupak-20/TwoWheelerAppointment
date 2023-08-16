package com.twowheeler.service;

import java.util.List;

import com.twowheeler.dao.CustomerDAOImpl;
import com.twowheeler.dao.ICustomerDAO;
import com.twowheeler.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private ICustomerDAO customerDAO;
	
	public CustomerServiceImpl() {
		customerDAO = new CustomerDAOImpl();
	}
	
	@Override
	public int insertCustomer(Customer customer) {
		return customerDAO.insertCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public int deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(custId);
	}

	@Override
	public Customer viewSingleCustomer(int custId) {
		// TODO Auto-generated method stub
		return customerDAO.viewCustomer(custId);
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return customerDAO.viewCustomers();
	}

}
