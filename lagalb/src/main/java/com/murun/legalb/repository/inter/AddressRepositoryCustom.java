package com.murun.legalb.repository.inter;

import com.murun.legalb.model.AddressList;


public interface AddressRepositoryCustom {
    AddressList getAddressByState(String state) ;
    AddressList getAddressByStateAndCity(String state, String city);
    AddressList getAddressByZip(String zipCode) ;
}
