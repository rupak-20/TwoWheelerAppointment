package com.twowheeler.dao;

import java.util.List;

import com.twowheeler.entity.Technician;

public interface ITechnicianDAO {
	
	 int insertTechnician(Technician technician);
	int updateTechnician(Technician technician);
	int deleteTechnician(int techId);
	Technician viewTechnician(int techId);
	List<Technician> viewTechnicians();
}
