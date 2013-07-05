package com.murun.addr.dao;

import org.springframework.stereotype.Repository;

import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;

@Repository
public class AddressDao {

	public AddressList getByZipCode( String zipCode ){
		AddressList retVal = new AddressList(); 
		for ( int i=0; i<10; i++){
			 
		System.out.println( zipCode + " " + i);
		    Address temp = new Address();
		    temp.setState(String.valueOf(i) + " state");
		    temp.setStreet( String.valueOf(i) + " street" );
		    temp.setZipCode( String.valueOf(i) );
			retVal.add( temp );
		}
		return retVal;
	}
	
	public Address getOne( String zipCode ){
		 
		System.out.println( zipCode + " getone");
		    Address temp = new Address();
		    temp.setState(String.valueOf(1) + " state");
		    temp.setStreet( String.valueOf(1) + " street" );
		    temp.setZipCode( String.valueOf(1) );
			 
		 
		return temp;
	}
}
