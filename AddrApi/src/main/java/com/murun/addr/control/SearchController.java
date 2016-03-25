package com.murun.addr.control;

 
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.murun.addr.model.AddressList;
import com.murun.addr.service.AddressService;
 

@RestController
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource
	AddressService addressService;
	
	@RequestMapping( method=RequestMethod.GET, value="/zipcode/{zipcode}", produces="application/json")
	public @ResponseBody AddressList findByZipCode( @PathVariable("zipcode") String zipCode ) {
		logger.info("Zipcode= "+zipCode);
		return addressService.getByZipCode( zipCode );
	}



	@RequestMapping("/name")
	public @ResponseBody AddressList findByName( @RequestParam("name") String name ) {
		logger.info("Name= "+name);
		return addressService.getByName( name );
	}
	
}
