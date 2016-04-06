package com.murun.legal.repository.inter;

import com.murun.legal.model.AddressList;


public interface AddressRepositoryCustom {
    AddressList getAddressByState(String state) ;
    AddressList getAddressByStateAndCity(String state, String city);
    AddressList getAddressByZip(String zipCode) ;
}
