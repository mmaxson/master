package com.murun.legal.repository.inter;

import com.murun.legal.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AddressRepository extends CrudRepository<Address, Integer>, AddressRepositoryCustom {

}




