package com.twowheeler.client;

import java.util.List;
import java.util.Scanner;

import com.twowheeler.controller.AppointmentController;
import com.twowheeler.controller.CustomerController;
import com.twowheeler.controller.ServiceController;
import com.twowheeler.controller.TechnicianController;
import com.twowheeler.entity.Appointment;
import com.twowheeler.entity.Customer;
import com.twowheeler.entity.Service;
import com.twowheeler.entity.Technician;

public class TwoWheelerClient {

	public static void main(String[] args) {
		int choice = -1;
		int innerChoice = -1;
		
		int custId = 0;
		String custName = null;
		String custAddress = null;
		String custContactNo = null;
		int techId;
		String techName;
		String techAddress;	
		String techContactNo;
		int apptId;
		int serId;
		String serDesc;
		double serCharges;
		
		CustomerController customerController = new CustomerController();
		TechnicianController technicianController = new TechnicianController();
		ServiceController serviceController = new ServiceController();
		AppointmentController appointmentController = new AppointmentController();
		
		Customer customer = null;
		Technician technician = null;
		Appointment appointment = null;
		Service service = null;
		
		Scanner scInput = new Scanner(System.in);
		do{
			System.out.println("Following is the choice:");
			System.out.println("1. Customer");
			System.out.println("2. Technician");
			System.out.println("3. Appointment");
			System.out.println("4. Service");
			System.out.println("0. Exit");
			
			choice = Integer.parseInt(scInput.nextLine());
			
			switch(choice) {
			case 1:
					do {
						System.out.println("Following is the choice:");
						System.out.println("1. Register Customer");
						System.out.println("2. Modify Customer Details");
						System.out.println("3. Delete Customer Record");
						System.out.println("4. View single customer");
						System.out.println("5. View all customers");
						System.out.println("0. Exit");
						
						innerChoice = Integer.parseInt(scInput.nextLine());
						
						switch(innerChoice) {
						case 1:
							System.out.print("Enter customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							System.out.print("Enter name: ");
							custName = scInput.nextLine();
							
							System.out.print("Enter address: ");
							custAddress = scInput.nextLine();
							
							System.out.print("Enter contact no: ");
							custContactNo = scInput.nextLine();
							
							customer = new Customer(custId, custName, custAddress, custContactNo);
		
							customerController.insertCustomer(customer);
							
							
							break;
							
						case 2:
							System.out.println("Enter the Customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							System.out.print("Enter name: ");
							custName = scInput.nextLine();
							
							System.out.print("Enter address: ");
							custAddress = scInput.nextLine();
							
							System.out.print("Enter contact no: ");
							custContactNo = scInput.nextLine();
							
							customer = new Customer(custId, custName, custAddress, custContactNo);
							
							customerController.modifyCustomer(customer);
							break;
							
						case 3:
							System.out.println("Enter the Customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							customerController.deleteCustomer(custId);
							break;
							
					    case 4:
							System.out.println("Enter the Customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							customer = customerController.viewSingleCustomer(custId);
							System.out.println(customer);
							break;
							
						case 5:
							System.out.println("List of Customers: ");
							List<Customer> customers = customerController.viewAllCustomer();
							System.out.println(customers);
						
							break;
						
						case 0:
							System.out.println("Exit Successful!");
							break;
							
						default:
							System.out.println("Wrong choice!");
							
						}
					}while(innerChoice != 0);
					break;
					
			case 2:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Register a Technician");
					System.out.println("2. Modify Technician Details");
					System.out.println("3. Delete Technician Record");
					System.out.println("4. View single Record");
					System.out.println("5. View all Records");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						techName = scInput.nextLine();
						
						System.out.print("Enter address: ");
						techAddress = scInput.nextLine();
						
						System.out.print("Enter contact no: ");
						techContactNo = scInput.nextLine();
						
						technician = new Technician(techId, techName, techAddress, techContactNo);
	
						technicianController.insertTechnician(technician);
						break;
						
					case 2:
						System.out.print("Enter Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						techName = scInput.nextLine();
						
						System.out.print("Enter address: ");
						techAddress = scInput.nextLine();
						
						System.out.print("Enter contact no: ");
						techContactNo = scInput.nextLine();
						
						technician = new Technician(techId, techName, techAddress, techContactNo);
						
						technicianController.updateTechnician(technician);
						break;
						
					case 3:
						System.out.println("Enter the Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						technicianController.deleteTechnician(techId);
						break;
						
					case 4:
						System.out.println("Enter the Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						technician=technicianController.viewTechnician(techId);
						System.out.println(technician);
						break;
						
					case 5:
						System.out.println("List of Technician: ");
						List<Technician>technicians=technicianController.viewAllTechnician();
						System.out.println(technicians);
						break;
					
					case 0:
						System.out.println("Exit Successful!");
						break;
						
					default:
						System.out.println("Wrong choice!");
						
					}
				}while(innerChoice != 0);
				break;
				
			case 3:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Book an Appointment");
					System.out.println("2. Modify Appointment Details");
					System.out.println("3. Delete Appointment Record");
					System.out.println("4. View single Record");
					System.out.println("5. View all Records");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter Appointment ID: ");
						apptId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						
						appointment = new Appointment(apptId, custId, techId, serId);
	
						appointmentController.insertAppointment(appointment);
						break;
						
					case 2:
						System.out.print("Enter Appointment ID: ");
						apptId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Technician ID: ");
						techId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						
						appointment = new Appointment(apptId, custId, techId, serId);
	
						appointmentController.updateAppointment(appointment);
						break;
	
						
					case 3:
						System.out.println("Enter the Appointment ID: ");
						apptId = Integer.parseInt(scInput.nextLine());
						appointmentController.deleteAppointment(apptId);
						break;
						
					case 4:
						System.out.println("Enter the Appointment ID: ");
						apptId = Integer.parseInt(scInput.nextLine());
						appointment=appointmentController.viewAppointment(apptId);
						System.out.println(appointment);
						break;
						
						
					case 5:
						System.out.println("List of Appointments: ");
						List<Appointment>appointments=appointmentController.viewAppointments();
						System.out.println(appointments);
						break;
						
					case 0:
						System.out.println("Exit Successful!");
						break;
						
					default:
						System.out.println("Wrong choice!");
						
					}
				}while(innerChoice != 0);
				break;
				
			case 4:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Enter a Repairing Service");
					System.out.println("2. Modify Service Details");
					System.out.println("3. Delete Service Record");
					System.out.println("4. View single Record");
					System.out.println("5. View all Records");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service Description: ");
						serDesc = scInput.nextLine();
						
						System.out.print("Enter Services Charges: ");
						serCharges = Double.parseDouble(scInput.nextLine());
						
						service = new Service(serId, serDesc, serCharges);
	
						serviceController.insertService(service);
						break;
						
					case 2:
						System.out.print("Enter Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service Description: ");
						serDesc = scInput.nextLine();
						
						System.out.print("Enter Service Charges: ");
						serCharges = Double.parseDouble(scInput.nextLine());
						
//						System.out.print("Enter Service ID: ");
//						serId = Integer.parseInt(scInput.nextLine());
						
						service = new Service(serId, serDesc, serCharges);
	
						serviceController.updateService(service);
						break;

						
					case 3:
						System.out.println("Enter the Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						serviceController.deleteService(serId);
						break;
						
					case 4:
						System.out.println("Enter the Service ID: ");
						serId = Integer.parseInt(scInput.nextLine());
						service=serviceController.viewService(serId);
						System.out.println(service);
						break;
						
					case 5:
						System.out.println("List of Service: ");
						List<Service>services=serviceController.viewServices();
						System.out.println(services);
						break;
						
					case 0:
						System.out.println("Exit Successful!");
						break;
					
					default:
						System.out.println("Wrong choice!");
						
					}
				}while(innerChoice != 0);
				break;
			
			}
		}while(choice != 0);
		scInput.close();
	}

}
