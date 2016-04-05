package com.murun.legal.repository;

import com.murun.legal.model.AddressList;
import com.murun.legal.repository.inter.AddressRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    public AddressList getAddressByState(String state) {
        AddressList retVal = new AddressList();

        retVal.setAll( em.createQuery(
                "SELECT a FROM Address a WHERE a.state = :state")
                .setParameter("state", state)
                //.setMaxResults(10)
                .getResultList());

        return retVal;
    }

    public AddressList getAddressByStateAndCity(String state, String city) {
        AddressList retVal = new AddressList();

        retVal.setAll( em.createQuery(
                "SELECT a FROM Address a WHERE a.state = :state and a.city = :city")
                .setParameter("state", state)
                .setParameter("city", city)
                //.setMaxResults(10)
                .getResultList());
        return retVal;
    }

    public AddressList getAddressByZip(String zipCode) {
        AddressList retVal = new AddressList();

        retVal.setAll( em.createQuery(
                "SELECT a FROM Address a WHERE a.zipCode = :zipCode")
                .setParameter("zipCode", zipCode)
                //.setMaxResults(10)
                .getResultList());
        return retVal;
    }


}
