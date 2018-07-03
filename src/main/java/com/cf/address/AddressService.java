package com.cf.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;
    public void addAddress(Address address)
    {
        addressDAO.addAddress(address);
    }

    public List<Address> getAllAddress(String phone)
    {
        List<Address> address =  addressDAO.getAllAddress(phone);
        return address;
    }
}
