package com.murun.legalb.repository.inter;

import com.murun.legalb.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Integer> {


}
