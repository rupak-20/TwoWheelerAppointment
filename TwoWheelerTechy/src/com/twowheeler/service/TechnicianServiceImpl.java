package com.twowheeler.service;

import java.util.List;

import com.twowheeler.dao.ITechnicianDAO;
import com.twowheeler.dao.TechnicianDAOImpl;
import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Technician;

public class TechnicianServiceImpl implements TechnicianService{

	private ITechnicianDAO technicianDAO;
	
	public TechnicianServiceImpl() {
		technicianDAO = new TechnicianDAOImpl();
	}
	
	@Override
	public int insertTechnician(Technician technician) {
		return technicianDAO.insertTechnician(technician);
	}

	@Override
	public int updateTechnician(Technician technician) {
		return technicianDAO.updateTechnician(technician);
	}

	@Override
	public int deleteTechnician(int techId) {
		return technicianDAO.deleteTechnician(techId);
	}

	@Override
	public Technician viewTechnician(int techId) {
		Technician technician = technicianDAO.viewTechnician(techId);
		return technician;
	}

	@Override
	public List<Technician> viewTechnicians() {
		return technicianDAO.viewTechnicians();
	}
}
