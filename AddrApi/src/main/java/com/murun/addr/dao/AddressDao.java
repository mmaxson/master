package com.murun.addr.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;

@Repository

public class AddressDao {

	private SessionFactory sessionFactory; 
	private static final String queryString = "from Address where zipCode = :zipCode";
      
	
	 @Resource
	   public void setSessionFactory(SessionFactory sessionFactory) {
	       this.sessionFactory = sessionFactory;
	   }
	 
	public AddressList getByZipCode( String zipCode ){
		AddressList retVal = new AddressList(); 
//		for ( int i=0; i<10; i++){
//			 
//		System.out.println( zipCode + " " + i);
//		    Address temp = new Address();
//		    temp.setState(String.valueOf(i) + " state");
//		    temp.setStreet( String.valueOf(i) + " street" );
//		    temp.setZipCode( String.valueOf(i) );
//			retVal.add( temp );
//		}
		
	    Query q = sessionFactory.getCurrentSession().createQuery( queryString );
	    q.setParameter("zipCode", zipCode);
	    retVal.setAll( q.list() );
	     
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
