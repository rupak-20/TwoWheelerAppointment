package com.twowheeler.service;

import java.util.List;

import com.twowheeler.dao.ServiceDAOImpl;
import com.twowheeler.dao.IServiceDAO;
import com.twowheeler.entity.Service;

public class ServiceServiceImpl implements ServiceService{

private IServiceDAO serviceDAO;
	
	public ServiceServiceImpl() {
		serviceDAO = new ServiceDAOImpl();
	}
	
	@Override
	public int insertService(Service service) {
		return serviceDAO.insertService(service);
	}

	@Override
	public int updateService(Service Service) {
		return serviceDAO.updateService(Service);
	}

	@Override
	public int deleteService(int serId) {
		return  serviceDAO.deleteService(serId);
	}

	@Override
	public Service viewService(int serId) {
		return serviceDAO.viewService(serId);
	}

	@Override
	public List<Service> viewServices() {
		return serviceDAO.viewServices();
	}
}
