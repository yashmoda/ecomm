package com.cf.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterDAO registerDAO;

    public int add(Register register)
    {
        return registerDAO.add(register);
    }
}
