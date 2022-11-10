package com.example.crud.rest;


import com.example.crud.model.CustomerUser;
import com.example.crud.service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/v1/customersUser/")
public class CustomerUserRestControllerV1 {
    private final CustomerUserService customerUserService;
    @Autowired
    public CustomerUserRestControllerV1(CustomerUserService customerUserService) {
        this.customerUserService = customerUserService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerUser> getByIdCustomerUser(@PathVariable("id")Long customerId){
        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CustomerUser customerUser = customerUserService.findById(customerId);
        if(customerUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerUser,HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerUser> postCustomerUser(@RequestBody CustomerUser customerUser){
        HttpHeaders headers = new HttpHeaders();
        if(customerUser == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerUserService.saveUser(customerUser);
        return new ResponseEntity<>(customerUser,headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerUser> putCustomerUser(@RequestBody CustomerUser customerUser, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if(customerUser == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerUserService.saveUser(customerUser);
        return new ResponseEntity<>(customerUser,headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerUser> deleteByIdCustomerUser(@PathVariable("id")Long customerId){
        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerUser customerUser = this.customerUserService.findById(customerId);
        if(customerUser == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerUserService.deleteUser(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerUser>> getAllCustomerUsers(){
        List<CustomerUser>  customerUsers = this.customerUserService.findAll();

        if(customerUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerUsers,HttpStatus.OK);
    }

}
