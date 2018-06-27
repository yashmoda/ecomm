package com.cf.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/com/cf/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(path = "/add")
    public ResponseEntity addAddress(@RequestBody Address address)
    {
        addressService.addAddress(address);
        return new ResponseEntity(HttpStatus.OK);
    }
}
