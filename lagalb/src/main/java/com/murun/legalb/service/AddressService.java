package com.murun.legalb.service;

import com.murun.legalb.model.Address;
import com.murun.legalb.model.AddressList;
import com.murun.legalb.repository.inter.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AddressService {

    @Resource
    AddressRepository addressRepository;


	public AddressList getAll(){
        AddressList al = new AddressList();
        al.add(addressRepository.findAll());
        return al;
	}

	public AddressList getByState( String state ){
        return addressRepository.getAddressByState( state );
	}

    public AddressList getByStateAndCity( String state, String city ){
        return addressRepository.getAddressByStateAndCity( state, city );
    }

    public AddressList getByZipCode(String zipCode){
        return addressRepository.getAddressByZip( zipCode );
    }

	public Address getById(int id){
        return addressRepository.findOne(id);
	}

	public int updateAddress( Address address ){
        Address ret = addressRepository.save( address );
		return ret.getId();
	}

    public int createAddress( Address address ){
        Address ret = addressRepository.save( address );
        return ret.getId();
    }


}
