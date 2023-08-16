package com.twowheeler.service;

import java.util.List;

import com.twowheeler.entity.Appointment;

public interface AppointmentService {

	public int insertAppointment(Appointment appointment);
	public int updateAppointment(Appointment appointment);
	public int deleteAppointment(int apptId);
	public Appointment viewAppointment(int apptId);
	public List<Appointment>viewAppointments();
}
