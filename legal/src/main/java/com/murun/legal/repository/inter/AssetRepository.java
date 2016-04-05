package com.murun.legal.repository.inter;

import com.murun.legal.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Integer> {


}
