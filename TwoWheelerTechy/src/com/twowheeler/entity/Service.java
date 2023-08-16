package com.twowheeler.entity;

import java.util.Objects;

public class Service {

	private int serId;
	private String serDesc;
	private double serCharges;
	
	public Service(int serId, String serDesc, double serCharges) {
		super();
		this.serId = serId;
		this.serDesc = serDesc;
		this.serCharges = serCharges;
	}
	
	public Service() {
		super();
	}

	public int getSerId() {
		return serId;
	}
	
	public void setSerId(int serId) {
		this.serId = serId;
	}
	
	public String getSerDesc() {
		return serDesc;
	}
	
	public void setSerDesc(String serDesc) {
		this.serDesc = serDesc;
	}
	
	public double getSerCharges() {
		return serCharges;
	}
	
	public void setSerCharges(double serCharges) {
		this.serCharges = serCharges;
	}

	@Override
	public int hashCode() {
		return serId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		return Double.doubleToLongBits(serCharges) == Double.doubleToLongBits(other.serCharges)
				&& Objects.equals(serDesc, other.serDesc) && serId == other.serId;
	}

	@Override
	public String toString() {
		return "Service [serId=" + serId + ", serDesc=" + serDesc + ", serCharges=" + serCharges + "]";
	}
	
	
	
}
