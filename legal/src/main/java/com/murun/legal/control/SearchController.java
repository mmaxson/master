package com.murun.legal.control;


import com.murun.legal.exceptions.NotFoundException;
import com.murun.legal.exceptions.InternalErrorException;
import com.murun.legal.model.Address;
import com.murun.legal.model.AddressList;
import com.murun.legal.model.Asset;
import com.murun.legal.model.SuccessResource;
import com.murun.legal.service.AddressService;
import com.murun.legal.service.AssetService;
import com.murun.legal.service.KMSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;


@RestController()
@RequestMapping("/addresses")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource
    private AddressService addressService;


    @Resource
    private AssetService assetService;

    @Resource
    private KMSClient kmsClient;


    @RequestMapping(method=RequestMethod.GET, value="/encrypt/{encrypt}", produces="application/json")
    public String encrypt(@PathVariable("encrypt")String clearText){
        logger.info("encrypt================================ ");
        return kmsClient.encryptData(clearText);
    }


    @RequestMapping(method=RequestMethod.GET, value="", produces="application/json")
    public AddressList getAll(){
        logger.info("getAll================================ ");
        return addressService.getAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/check/{check}", produces="application/json")
    public ResponseEntity<String> healthCheck(@PathVariable("check") String dummy){
        logger.info("check================================ ");
        return  ResponseEntity.ok().body("OK");
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

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid parameter: Id needs to be numeric.");
        }

        Address retVal = addressService.getById(id);
        if (retVal == null){
            throw new NotFoundException("Address with id " + id + " does not exist.");
        }

        return retVal;
	}


    @RequestMapping(method = RequestMethod.PUT, value= "/id/{id}", produces="application/json")
    public ResponseEntity<SuccessResource> updateAddress(@PathVariable("id") int id, @RequestBody Address address) {
        logger.info("Id================ "+id);

        Address currentAddress = addressService.getById(id);

        if (currentAddress==null) {
            throw new NotFoundException("Address with id " + id + " does not exist.");
        }


        currentAddress.setStreet(address.getStreet());
        currentAddress.setCity(address.getCity());
        currentAddress.setState(address.getState());
        currentAddress.setZipCode(address.getZipCode());

        int retVal= addressService.updateAddress(currentAddress);

        if (retVal != 1){
            throw new IllegalStateException("Cannot update row with id = " + id);
        }

        SuccessResource sr =new SuccessResource("Success", "Row with id " + id + " updated.");
        return new ResponseEntity<SuccessResource>(sr, new HttpHeaders(), CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value= "", produces="application/json")
    public ResponseEntity<SuccessResource> createAddress(@RequestBody Address address) {

        int retVal= addressService.createAddress(address);

        if (retVal <= 0){
            throw new IllegalStateException("Cannot create row.");
        }

        SuccessResource sr =new SuccessResource("Success", "Row with id " + retVal + " was created.");

        return new ResponseEntity<SuccessResource>(sr, new HttpHeaders(), CREATED);
    }


    //Postman: Set header multipart/d
    //

    @RequestMapping(method = RequestMethod.POST, value = "/uploadfile/{title}", produces = "application/json")
    public ResponseEntity<SuccessResource> createDocument(@PathVariable("title") String title, @RequestParam("file") MultipartFile fileToUpload) {


        if (fileToUpload == null) {
            throw new IllegalArgumentException("File to be uploaded is missing.");
        }


        Asset doc = new Asset();
        doc.setTitle(title);
        doc.setType(fileToUpload.getContentType());

        try {
            doc.setAssetData(fileToUpload.getBytes());
        } catch (IOException e) {
            throw new InternalErrorException(e, "createDocument", "IOError reading bytes.");
        }


        int retVal = assetService.createDocument(doc);

        SuccessResource sr = new SuccessResource("Success", "Row with id " + retVal + " was created.");

        return new ResponseEntity<SuccessResource>(sr, new HttpHeaders(), HttpStatus.CREATED);
    }


    @RequestMapping(method=RequestMethod.GET, value="/download/{id}",  produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPDFFile(@PathVariable("id") int id) throws IOException {

        Asset document = assetService.getDocumentById(id);

        if ( document == null ){
            throw new NotFoundException("Asset with id = " + id + " does not exist.");

        }
        return ResponseEntity
                .ok()
                .contentLength(document.getAssetData().length)
                .contentType( MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(document.getAssetData())));
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
//        this.validateUser(userId);
//        return this.accountRepository
//                .findByUsername(userId)
//                .map(account -> {
//                    Bookmark result = bookmarkRepository.save(new Bookmark(account,
//                            input.uri, input.description));
//
//                    HttpHeaders httpHeaders = new HttpHeaders();
//                    httpHeaders.setLocation(ServletUriComponentsBuilder
//                            .fromCurrentRequest().path("/{id}")
//                            .buildAndExpand(result.getId()).toUri());
//                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
//                }).get();
//
//    }
}
