package com.twowheeler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Technician;
import com.twowheeler.utility.DBUtil;

public class TechnicianDAOImpl implements ITechnicianDAO{
	
	@Override
	public int insertTechnician(Technician technician) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO technician VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, technician.getTechId());
			pstStudent.setString(2, technician.getTechName());
			pstStudent.setString(3, technician.getTechAddress());
			pstStudent.setString(4, technician.getTechContactNo());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with technician ID " + technician.getTechId());
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
	public int updateTechnician(Technician technician) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE technician SET techName = ?, techAddress = ?, techContactNo = ? WHERE techId = ?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, technician.getTechName());
			pstStudent.setString(2, technician.getTechAddress());
			pstStudent.setString(3, technician.getTechContactNo());
			pstStudent.setInt(4, technician.getTechId());
			
			
			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with technician ID " + technician.getTechId());
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
	public int deleteTechnician(int techId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM technician WHERE techId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, techId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with technician ID " + techId);
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
	public Technician viewTechnician(int techId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsTechnician = null;
		String sql = new String("SELECT * FROM technician WHERE techId=?");

		Technician technician = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, techId);
			

			rsTechnician = pstStudent.executeQuery();

			while(rsTechnician.next()) {
				technician = new Technician();
				technician.setTechId(rsTechnician.getInt("techId"));
				technician.setTechName(rsTechnician.getString("techname"));
				technician.setTechAddress(rsTechnician.getString("techaddress"));
				technician.setTechContactNo(rsTechnician.getString("techcontactno"));
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
		
		return technician;

	}

	@Override
	public List<Technician> viewTechnicians() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsTechnician = null;
		String sql = new String("SELECT * FROM technician");

		Technician technician = null;
		List<Technician>technicians= new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsTechnician = pstStudent.executeQuery();

			while(rsTechnician.next()) {
				technician = new Technician();
				technician.setTechId(rsTechnician.getInt("techId"));
				technician.setTechName(rsTechnician.getString("techname"));
				technician.setTechAddress(rsTechnician.getString("techaddress"));
				technician.setTechContactNo(rsTechnician.getString("techcontactno"));
				
				technicians.add(technician);
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
		
		return technicians;

	}
}
