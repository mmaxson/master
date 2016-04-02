package com.murun.addr.service;

import com.murun.addr.dao.AddressDao;
import com.murun.addr.dao.DocumentDao;
import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;
import com.murun.addr.model.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DocumentService {


	@Resource
	DocumentDao documentDao;



	public int createDocument(Document document){
		return documentDao.createDocument(document);
	}

	public Document getDocumentById(int id){
		return documentDao.getDocumentById(id);
	}


}
