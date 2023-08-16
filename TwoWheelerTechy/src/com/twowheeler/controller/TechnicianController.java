package com.twowheeler.controller;

import java.util.List;

import com.twowheeler.entity.Technician;
import com.twowheeler.service.TechnicianService;
import com.twowheeler.service.TechnicianServiceImpl;

public class TechnicianController {
	
	private TechnicianService technicianService;

	public TechnicianController() {
		technicianService = new TechnicianServiceImpl();
	}
	
	public void insertTechnician(Technician technician) {
		int status = technicianService.insertTechnician(technician);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	public void updateTechnician(Technician technician) {
		int status = technicianService.updateTechnician(technician);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	public void deleteTechnician(int techId) {
		int status = technicianService.deleteTechnician(techId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	public Technician viewTechnician(int techId) {
		Technician technician = technicianService.viewTechnician(techId);
		return technician;
	}
	
	public List<Technician> viewAllTechnician(){
		return technicianService.viewTechnicians();
				
	}
}
