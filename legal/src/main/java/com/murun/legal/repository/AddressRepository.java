package com.murun.legal.repository;

import com.murun.legal.model.Address;
import com.murun.legal.model.AddressList;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {

    AddressList getByState(String state) ;
    AddressList getByStateAndCity(String state, String city);
    AddressList getByZipCode(String zipCode) ;

}




