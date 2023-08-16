package com.twowheeler.entity;

import java.util.Objects;

public class Technician {
	private int techId;
	private String techName;
	private String techAddress;
	private String techContactNo;

	
	public Technician() {
	}

	public Technician(int techId, String techName, String techAddress, String techContactNo) {
		super();
		this.techId = techId;
		this.techName = techName;
		this.techAddress = techAddress;
		this.techContactNo = techContactNo;
	}
	
	public int getTechId() {
		return techId;
	}
	
	public void setTechId(int techId) {
		this.techId = techId;
	}
	
	public String getTechName() {
		return techName;
	}
	
	public void setTechName(String techName) {
		this.techName = techName;
	}
	
	public String getTechAddress() {
		return techAddress;
	}
	
	public void setTechAddress(String techAddress) {
		this.techAddress = techAddress;
	}
	
	public String getTechContactNo() {
		return techContactNo;
	}
	
	public void setTechContactNo(String techContactNo) {
		this.techContactNo = techContactNo;
	}
	

	@Override
	public String toString() {
		return "Technician [techId=" + techId + ", techName=" + techName + ", techAddress=" + techAddress
				+ ", techContactNo=" + techContactNo + "]";
	}

	@Override
	public int hashCode() {
		return techId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technician other = (Technician) obj;
		return Objects.equals(techAddress, other.techAddress) && Objects.equals(techContactNo, other.techContactNo)
				&& techId == other.techId && Objects.equals(techName, other.techName);
	}
	
	
}