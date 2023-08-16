package com.twowheeler.service;

import java.util.List;

import com.twowheeler.entity.Service;

public interface ServiceService {

	public int insertService(Service service);
	public int updateService(Service service);
	public int deleteService(int serId);
	public Service viewService(int serId);
	public List<Service>viewServices();
}
