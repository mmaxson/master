package com.murun.addr.dao;

import com.murun.addr.model.Document;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DocumentDao {

    private SessionFactory sessionFactory;
    private static final String queryStringGetByTitle= "from Document where title = :title ";

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public int createDocument(Document document){
        Integer retVal = (Integer) sessionFactory.getCurrentSession().save(document);
        return retVal;
    }

    public Document getDocumentById(int id){
        return (Document) sessionFactory.getCurrentSession().get(Document.class, id);
    }

}
