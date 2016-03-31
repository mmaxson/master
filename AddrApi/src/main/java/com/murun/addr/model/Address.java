package com.murun.addr.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

 

@Entity

@XmlRootElement(name = "address")
public class Address {

	@Id
	private int id;
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address() {
	}

//	public Address( String street, String state, String zipCode) {
//		super();
//		Street = street;
//		State = state;
//		ZipCode = zipCode;
//	}
	
	
	public int getId() {
		return id;
	}

	@XmlElement
	public void setId( int id) {
		this.id = id;
	}

	
	@XmlElement
	public void setStreet( String street) {
		this.street = street;
	}

	@XmlElement
	public void setCity( String city) {
		this.city = city;
	}

	@XmlElement
	public void setState( String state) {
		this.state = state;
	}

	@XmlElement
	public void setZipCode( String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}


}
