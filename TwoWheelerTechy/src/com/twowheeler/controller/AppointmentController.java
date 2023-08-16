package com.twowheeler.controller;

import java.util.List;

import com.twowheeler.entity.Appointment;
import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Technician;
import com.twowheeler.service.AppointmentService;
import com.twowheeler.service.AppointmentServiceImpl;

public class AppointmentController {

	private AppointmentService appointmentService;

	public AppointmentController() {
		appointmentService = new AppointmentServiceImpl();
	}
	
	public void insertAppointment(Appointment appointment) {
		int status = appointmentService.insertAppointment(appointment);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateAppointment(Appointment appointment) {
		int status = appointmentService.updateAppointment(appointment);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteAppointment(int apptId) {
		int status =appointmentService.deleteAppointment(apptId);
		
		if(status > 0) {
			System.out.println("Record successfully deleted.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Appointment viewAppointment(int apptId) {
		Appointment appointment = appointmentService.viewAppointment(apptId);
		return appointment;
	}
	
	public List<Appointment> viewAppointments() {
		return appointmentService.viewAppointments();
	}
}
