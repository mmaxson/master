package com.murun.addr.dao;

import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;
import com.murun.addr.model.Document;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository

public class AddressDao {

    private SessionFactory sessionFactory;

    private static final String queryStringGetAll = "from Address";
    private static final String queryStringByState = "from Address where state = :state ";
    private static final String queryStringByStateAndCity = "from Address where state = :state and city = :city ";
    private static final String queryStringByZipCode = "from Address where zipCode = :zipCode ";


    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AddressList getAll() {
        AddressList retVal = new AddressList();

        Query q = sessionFactory.getCurrentSession().createQuery(queryStringGetAll);
        retVal.setAll(q.list());

        return retVal;
    }

    public AddressList getByState(String state) {
        AddressList retVal = new AddressList();

        Query q = sessionFactory.getCurrentSession().createQuery(queryStringByState);
        q.setParameter("state", state);
        retVal.setAll(q.list());

        return retVal;
    }

    public AddressList getByStateAndCity(String state, String city) {
        AddressList retVal = new AddressList();

        Query q = sessionFactory.getCurrentSession().createQuery(queryStringByStateAndCity);
        q.setParameter("state", state);
        q.setParameter("city", city);
        retVal.setAll(q.list());

        return retVal;
    }

    public AddressList getByZipCode(String zipCode) {
        AddressList retVal = new AddressList();

        Query q = sessionFactory.getCurrentSession().createQuery(queryStringByZipCode);
        q.setParameter("zipCode", zipCode);
        retVal.setAll(q.list());

        return retVal;
    }

    public Address getOne(String zipCode) {

        System.out.println(zipCode + " getone");
        Address temp = new Address();
        temp.setStreet(String.valueOf(1) + " street");
        temp.setState(String.valueOf(1) + " state");
        temp.setZipCode(String.valueOf(1));

        return temp;
    }


    public Address getById(int id) {
        return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
    }

    public int updateAddress(Address address) {
        sessionFactory.getCurrentSession().update(address);
        return 1;
    }


    public int createAddress(Address address) {
        Integer retVal = (Integer) sessionFactory.getCurrentSession().save(address);
        return retVal;
    }


}
