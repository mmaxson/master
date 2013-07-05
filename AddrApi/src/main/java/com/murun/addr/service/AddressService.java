package com.murun.addr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.murun.addr.dao.AddressDao;
import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;

@Service
public class AddressService {

	@Resource
	AddressDao addressDao;

	public AddressList getByZipCode( String zipCode ){
		return  addressDao.getByZipCode( zipCode );
	}
	
	public Address getOne( String zipCode ){
		return  addressDao.getOne( zipCode );
	}
}
