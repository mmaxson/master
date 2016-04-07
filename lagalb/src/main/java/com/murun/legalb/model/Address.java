package com.murun.legalb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

 

@Entity

@XmlRootElement(name = "address")
public class Address {

	@Id
    @GeneratedValue
	private int id;
	
	private String street;
	//@Size(max = 30)
	private String city;

	//@Size(max = 2)
	private String state;

//	@Size(max = 5)
	private String zipCode;
	
	public Address() {
	}

	
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
