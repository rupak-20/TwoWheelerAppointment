package com.twowheeler.dao;

import java.util.List;

import com.twowheeler.entity.Appointment;

public interface IAppointmentDAO {

	int insertAppointment(Appointment technician);
	int updateAppointment(Appointment technician);
	int deleteAppointment(int techId);
	Appointment viewAppointment(int techId);
	List<Appointment> viewAppointments();
}
