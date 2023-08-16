package com.twowheeler.dao;

import java.util.List;

import com.twowheeler.entity.Service;

public interface IServiceDAO {
	
	int insertService(Service service);
	int updateService(Service service);
	int deleteService(int techId);
	Service viewService(int techId);
	List<Service> viewServices();

}
