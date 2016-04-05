package com.murun.legal.service;


import com.murun.legal.model.Asset;
import com.murun.legal.repository.inter.AssetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AssetService {

	@Resource
	AssetRepository assetRepository;

	public int createDocument(Asset asset){
		Asset retVal =  assetRepository.save(asset);
		return retVal.getId();
	}

	public Asset getDocumentById(int id){
		return assetRepository.findOne(id);
	}


}
