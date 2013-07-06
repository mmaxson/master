package com.murun.addr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "address")
public class AddressList {
	@XmlElement
	private List<Address> addressList = new ArrayList<Address>();
	
	public AddressList(){
	}

	
	public void add( Address address ){
		addressList.add( address );
	}
	
	public List<Address> getAll(){
		return addressList;
	}
	
	public void setAll( List<Address> addressList ){
		this. addressList = addressList ;
	}
}
