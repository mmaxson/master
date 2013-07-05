package com.murun.addr.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {

	private String street;
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
	
	@XmlElement
	public void setStreet( String street) {
		this.street = street;
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

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}


}
