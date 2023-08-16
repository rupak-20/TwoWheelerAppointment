package com.twowheeler.service;

import java.util.List;

import com.twowheeler.entity.Technician;

public interface TechnicianService {

	public int insertTechnician(Technician sechnician);
	public int updateTechnician(Technician technician);
	public int deleteTechnician(int techId);
	public Technician viewTechnician(int techId);
	public List<Technician>viewTechnicians();
}
