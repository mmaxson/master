package com.murun.addr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murun.addr.dao.AddressDao;
import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;

@Service
@Transactional
public class AddressService {

	@Resource
	AddressDao addressDao;

	public AddressList getByZipCode( String zipCode ){
		return addressDao.getByZipCode( zipCode );
	}

	public AddressList getByName( String zipCode ){
		return addressDao.getByName( zipCode );
	}

	public Address getOne( String zipCode ){
		return addressDao.getOne( zipCode );
	}
}
