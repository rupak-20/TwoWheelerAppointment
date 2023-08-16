package com.twowheeler.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.twowheeler.entity.Customer;
import com.twowheeler.utility.DBUtil;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public int insertCustomer(Customer customer) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO customer VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, customer.getCustId());
			pstStudent.setString(2, customer.getName());
			pstStudent.setString(3, customer.getAddress());
			pstStudent.setString(4, customer.getContactNo());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with customer ID " + customer.getCustId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public int updateCustomer(Customer customer) {
		
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE customer SET custName = ?, custaddress = ?, custContactNo = ? WHERE custId = ?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, customer.getName());
			pstStudent.setString(2, customer.getAddress());
			pstStudent.setString(3, customer.getContactNo());
			pstStudent.setInt(4, customer.getCustId());
			
			
			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with customer ID " + customer.getCustId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
		
	}

	@Override
	public int deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM customer WHERE custid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with customer ID " + custId);
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public Customer viewCustomer(int custId) {
		// TODO Auto-generated method stub
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer WHERE custId=?");

		Customer customer = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer();
				customer.setCustId(rsCustomer.getInt("custId"));
				customer.setName(rsCustomer.getString("custName"));
				customer.setAddress(rsCustomer.getString("custAddress"));
				customer.setContactNo(rsCustomer.getString("custContactno"));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer");

		Customer customer = null;
		List<Customer>customers = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer();
				customer.setCustId(rsCustomer.getInt("custId"));
				customer.setName(rsCustomer.getString("custname"));
				customer.setAddress(rsCustomer.getString("custaddress"));
				customer.setContactNo(rsCustomer.getString("custcontactno"));
				
				customers.add(customer);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return customers;
	}

}
