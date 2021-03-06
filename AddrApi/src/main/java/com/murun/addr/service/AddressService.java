package com.murun.addr.service;

import javax.annotation.Resource;

import com.murun.addr.dao.DocumentDao;
import com.murun.addr.model.Document;
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


	public AddressList getAll(){
		return addressDao.getAll();
	}

	public AddressList getByState( String state ){
		return addressDao.getByState( state );
	}

    public AddressList getByStateAndCity( String state, String city ){
        return addressDao.getByStateAndCity( state, city );
    }

    public AddressList getByZipCode(String zipCode){
        return addressDao.getByZipCode( zipCode );
    }

	public Address getById(int id){
        return addressDao.getById(id);
	}

	public int updateAddress( Address address ){
		return addressDao.updateAddress( address );
	}

    public int createAddress( Address address ){
        return addressDao.createAddress( address );
    }

	public Address getOne( String zipCode ){
		return addressDao.getOne( zipCode );
	}
}
