package com.murun.addr.control;


import com.murun.addr.exceptions.AddressNotFoundException;
import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;
import com.murun.addr.model.SuccessResource;
import com.murun.addr.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;




@RestController()
@RequestMapping("/addresses")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource
	AddressService addressService;


    @RequestMapping(method=RequestMethod.GET, value="", produces="application/json")
    public AddressList getAll(){
        logger.info("getAll================================ ");
        return addressService.getAll();
    }


	@RequestMapping(method=RequestMethod.GET, value="/zipcode/{zipcode}", produces="application/json")
	public AddressList findByZipCode( @PathVariable("zipcode") String zipCode ) {
		logger.info("Zipcode================================ "+zipCode);
		return addressService.getByZipCode(zipCode);
	}

    @RequestMapping(method=RequestMethod.GET, value="/state/{state}", produces="application/json")
    public AddressList findByState( @PathVariable("state") String state, @RequestParam(value="city", required =false) String city ) {
        logger.info("State"+state + "?City=" + city );
        if ( city == null ){
            return addressService.getByState(state);
        }
        else{
            return addressService.getByStateAndCity(state, city);
        }

    }

	@RequestMapping(method=RequestMethod.GET, value="/id/{id}", produces="application/json")
    public Address findById(@PathVariable("id") String idStr) {
		logger.info("Id================ "+idStr);

        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid parameter: Id needs to be numeric.");
        }

        Address retVal = addressService.getById(id);
        if (retVal == null){
            throw new AddressNotFoundException(id);
        }

        return retVal;
	}


    @RequestMapping(method = RequestMethod.PUT, value= "/id/{id}", produces="application/json")
    public SuccessResource updateAddress(@PathVariable("id") int id, @RequestBody Address address) {
        logger.info("Id================ "+id);

        Address currentAddress = addressService.getById(id);

        if (currentAddress==null) {
            System.out.println("User with id " + id + " not found");
            throw new AddressNotFoundException(id);
        }


        currentAddress.setStreet(address.getStreet());
        currentAddress.setCity(address.getCity());
        currentAddress.setState(address.getState());
        currentAddress.setZipCode(address.getZipCode());

        int retVal= addressService.updateAddress(currentAddress);
        logger.info("retval================ "+retVal);

        if (retVal != 1){
            throw new IllegalStateException("Cannot update row with id = " + id);
        }
        return new SuccessResource("Success", "Row with id " + id + " updated.");
    }

}
