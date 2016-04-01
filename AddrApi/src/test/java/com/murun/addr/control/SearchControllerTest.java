package com.murun.addr.control;


import com.google.gson.Gson;
import com.murun.addr.model.Address;
import com.murun.addr.model.AddressList;
import com.murun.addr.service.AddressService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/servlet-context.xml")

public class SearchControllerTest{

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Mock
    protected AddressService addressService = Mockito.mock(AddressService.class);

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;


    private HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();


    @Autowired
    private WebApplicationContext webApplicationContext;

    private ObjectMapper mapper = new ObjectMapper();

    private Gson gson = new Gson();


    @Before
    public void setup() throws Exception {

        mockMvc = MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(webApplicationContext).build();


//        this.account = accountRepository.save(new Account(userName, "password"));
//        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + userName, "A description")));
//        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + userName, "A description")));
    }


    private Address createAddress(int id){
        Address address = new Address();
        address.setId(id);
        address.setStreet("Street " +  id);
        address.setCity("City " + id );
        address.setState(String.valueOf(id));
        address.setZipCode(String.valueOf(id) + String.valueOf(id) + String.valueOf(id) );
        return address;
    }

    @Test
    public void testGetById() throws Exception {
        Mockito.when(addressService.getById(1)).thenReturn(new Address());
        mockMvc.perform(get("/addresses/id/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetZipCode() throws Exception {
        Mockito.when(addressService.getByZipCode("90402")).thenReturn(new AddressList());
        mockMvc.perform(get("/addresses/zipcode/90402")).andExpect(status().isOk());
    }

    @Test
    public void testGetByState() throws Exception {
        Mockito.when(addressService.getByState("CA")).thenReturn(new AddressList());
        mockMvc.perform(get("/addresses/state/CA")).andExpect(status().isOk());
    }

    @Test
    public void testGetByStateAndCity() throws Exception {
        Mockito.when(addressService.getByStateAndCity("CA", "SANTA MONICA")).thenReturn(new AddressList());
        mockMvc.perform(get("/addresses/state/CA?city=santa monica")).andExpect(status().isOk());
    }

    @Test
    public void testPutById() throws Exception {

        Address address = createAddress(1);

        Mockito.when(addressService.getById(1)).thenReturn(address);
        Mockito.when(addressService.updateAddress(address)).thenReturn(1);

        mockMvc.perform( put("/addresses/id/1")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(gson.toJson(address)))
                         .andExpect(status().isCreated());
    }

    @Test
    public void testCreateAddress() throws Exception {

        Address address = createAddress(1);
        Mockito.when(addressService.createAddress(address)).thenReturn(1);

        mockMvc.perform( post("/addresses/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(address)))
                .andExpect(status().isCreated());
    }
}

