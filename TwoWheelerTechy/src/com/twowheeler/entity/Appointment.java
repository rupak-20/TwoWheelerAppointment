package com.twowheeler.entity;


public class Appointment {

	private int apptId;
	private int custId;
	private int techId;
	private int serId;
	
	
	
	public Appointment() {
	}

	public Appointment(int apptId, int custId, int techId, int serId) {
		super();
		this.apptId = apptId;
		this.custId = custId;
		this.techId = techId;
		this.serId = serId;
	}
	
	public int getApptId() {
		return apptId;
	}
	
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	
	public int getCustId() {
		return custId;
	}
	
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public int getTechId() {
		return techId;
	}
	
	public void setTechId(int techId) {
		this.techId = techId;
	}
	
	public int getSerId() {
		return serId;
	}
	
	public void setSerId(int serId) {
		this.serId = serId;
	}

	
	
	@Override
	public int hashCode() {
		return apptId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return apptId == other.apptId && custId == other.custId && serId == other.serId && techId == other.techId;
	}

	@Override
	public String toString() {
		return "Appointment [apptId=" + apptId + ", custId=" + custId + ", techId=" + techId + ", serId=" + serId + "]";
	}
	
	
}
