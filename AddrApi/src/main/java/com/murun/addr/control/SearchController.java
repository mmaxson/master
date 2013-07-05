package com.murun.addr.control;

 
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.murun.addr.model.AddressList;
import com.murun.addr.service.AddressService;
 

@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource
	AddressService addressService;
	 
	
	@RequestMapping(method=RequestMethod.GET, value="/zipcode/{zipcode}", produces="application/xml")
	public @ResponseBody AddressList findByZipCode(@PathVariable("zipcode") String zipCode ) {
		logger.info("...................findByZipCode....2......");
		return addressService.getByZipCode( zipCode );
	}
	
}
