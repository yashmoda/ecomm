package com.cf.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;
    public void addAddress(Address address)
    {
        addressDAO.addAddress(address);
    }
}
