package com.twowheeler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Service;
import com.twowheeler.utility.DBUtil;

public class ServiceDAOImpl implements IServiceDAO{

	@Override
	public int insertService(Service service) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO service VALUES(?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, service.getSerId());
			pstStudent.setString(2, service.getSerDesc());
			pstStudent.setDouble(3, service.getSerCharges());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with service ID " + service.getSerId());
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
	public int updateService(Service service) {

		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE service SET serDesc = ?, serCharges = ? WHERE serId = ?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, service.getSerDesc());
			pstStudent.setDouble(2, service.getSerCharges());
			//pstStudent.setString(3, customer.getContactNo());
			pstStudent.setInt(3, service.getSerId());
			
			
			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with service ID " + service.getSerId());
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
	public int deleteService(int serId) {
		// TODO Auto-generated method stub
				int status = 0;

				Connection connStudent = null;
				PreparedStatement pstStudent = null;

				String sql = new String("DELETE FROM service WHERE serId=?");

				try {
					connStudent = DBUtil.createConnection();

					pstStudent = connStudent.prepareStatement(sql);
					pstStudent.setInt(1, serId);
					

					status = pstStudent.executeUpdate();

					System.out.println("Record deleted successfully with service ID " + serId);
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
	public Service viewService(int serId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM service WHERE serId=?");

		Service service = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, serId);
			

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				service = new Service();
				service.setSerId(rsService.getInt("serId"));
				service.setSerDesc(rsService.getString("serDesc"));
				service.setSerCharges(rsService.getDouble("serCharges"));
				//customer.setContactNo(rsCustomer.getString("contactno"));
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
		
		return service;
	}

	@Override
	public List<Service> viewServices() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM service");

		Service service = null;
		List<Service>services = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				service = new Service();
				service.setSerId(rsService.getInt("SerId"));
				service.setSerDesc(rsService.getString("SerDesc"));
				service.setSerCharges(rsService.getDouble("SerCharges"));
				//service.setContactNo(rsService.getString("contactno"));
				
				services.add(service);
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
		
		return services;
	}
}
