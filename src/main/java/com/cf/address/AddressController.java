package com.cf.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get_address")
    public ResponseEntity<List<Address>> getAllAddress(@RequestParam String phone)
    {
        List<Address> address  = addressService.getAllAddress(phone);
        return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
    }
}
