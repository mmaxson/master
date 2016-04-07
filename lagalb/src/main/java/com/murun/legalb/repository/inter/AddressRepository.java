package com.murun.legalb.repository.inter;

import com.murun.legalb.model.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, Integer>, AddressRepositoryCustom {

}




