package com.twowheeler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twowheeler.entity.Appointment;
import com.twowheeler.entity.Customer;
import com.twowheeler.utility.DBUtil;

public class AppointmentDAOImpl implements IAppointmentDAO{

	@Override
	public int insertAppointment(Appointment appointment) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO appointment VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointment.getApptId());
			pstStudent.setInt(2, appointment.getCustId());
			pstStudent.setInt(3, appointment.getTechId());
			pstStudent.setInt(4, appointment.getSerId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with appointment ID " + appointment.getApptId());
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
	public int updateAppointment(Appointment appointment) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE appointment SET custId = ?, techId = ?, serId = ? WHERE apptId = ?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointment.getCustId());
			pstStudent.setInt(2, appointment.getTechId());
			pstStudent.setInt(3, appointment.getSerId());
			pstStudent.setInt(4, appointment.getApptId());
			
			
			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with appointment ID " + appointment.getApptId());
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
	public int deleteAppointment(int ApptId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM appointment WHERE ApptId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, ApptId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with Appointment ID " + ApptId);
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
	public Appointment viewAppointment(int ApptId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsAppointment = null;
		String sql = new String("SELECT * FROM appointment WHERE apptId=?");

		Appointment appointment = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, ApptId);
			

			rsAppointment = pstStudent.executeQuery();

			while(rsAppointment.next()) {
				appointment = new Appointment();
				appointment.setCustId(rsAppointment.getInt("custId"));
				appointment.setApptId(rsAppointment.getInt("apptId"));
				appointment.setTechId(rsAppointment.getInt("techId"));
				appointment.setSerId(rsAppointment.getInt("serId"));
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
		
		return appointment;
	}

	@Override
	public List<Appointment> viewAppointments() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsAppointment = null;
		String sql = new String("SELECT * FROM appointment");

		Appointment appointment = null;
		List<Appointment> appointments = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsAppointment = pstStudent.executeQuery();

			while(rsAppointment.next()) {
				appointment = new Appointment();
				appointment.setCustId(rsAppointment.getInt("custId"));
				appointment.setApptId(rsAppointment.getInt("ApptId"));
				appointment.setTechId(rsAppointment.getInt("TechId"));
				appointment.setSerId(rsAppointment.getInt("SerId"));
				
				appointments.add(appointment);
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
		
		return appointments;
	}
	
}
