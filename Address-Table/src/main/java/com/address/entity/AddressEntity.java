package com.address.entity;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AddressTable")
public class AddressEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long AddressId;
	private String address;
	private int    houseno;
	private String area;
	private String landMark;
	private Long    contact;
	public AddressEntity() {
		super();
	}
	public AddressEntity(Long addressId, String address, int houseno, String area, String landMark, Long contact) {
		super();
		AddressId = addressId;
		this.address = address;
		this.houseno = houseno;
		this.area = area;
		this.landMark = landMark;
		this.contact = contact;
	}
	public Long getAddressId() {
		return AddressId;
	}
	public void setAddressId(Long addressId) {
		AddressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	
	
}
