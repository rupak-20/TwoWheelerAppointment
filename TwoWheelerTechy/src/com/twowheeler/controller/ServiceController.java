package com.twowheeler.controller;

import java.util.List;

import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Service;
import com.twowheeler.service.ServiceService;
import com.twowheeler.service.ServiceServiceImpl;

public class ServiceController {

	private ServiceService serviceService;

	public ServiceController() {
		serviceService = new ServiceServiceImpl();
	}
	
	public void insertService(Service service) {
		int status = serviceService.insertService(service);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	public void updateService(Service service) {
		int status = serviceService.updateService(service);
		
		if(status > 0) {
			System.out.println("Record modified successfully.");
		}else {
			System.out.println("Record couldn't be modified");
		}
	}
	
	public void deleteService(int serId) {
		int status = serviceService.deleteService(serId);
		
		if(status > 0) {
			System.out.println("Record successfully deleted.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Service viewService(int serId) {
		Service service = serviceService.viewService(serId);
		return service;
	}
	
	public List<Service> viewServices() {
		
		return serviceService.viewServices();
	}
}
