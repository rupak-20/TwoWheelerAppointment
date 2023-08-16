package com.twowheeler.service;

import java.util.List;

import com.twowheeler.dao.AppointmentDAOImpl;
import com.twowheeler.dao.IAppointmentDAO;
import com.twowheeler.entity.Appointment;

public class AppointmentServiceImpl implements AppointmentService{

private IAppointmentDAO appointmentDAO;
	
	public AppointmentServiceImpl() {
		appointmentDAO = new AppointmentDAOImpl();
	}
	
	@Override
	public int insertAppointment(Appointment appointment) {
		return appointmentDAO.insertAppointment(appointment);
	}

	@Override
	public int updateAppointment(Appointment appointment) {
		return appointmentDAO.updateAppointment(appointment);
	}

	@Override
	public int deleteAppointment(int apptId) {
		return appointmentDAO.deleteAppointment(apptId);
	}

	@Override
	public Appointment viewAppointment(int apptId) {
		return appointmentDAO.viewAppointment(apptId);
	}

	@Override
	public List<Appointment> viewAppointments() {
		return appointmentDAO.viewAppointments();
	}

	}

