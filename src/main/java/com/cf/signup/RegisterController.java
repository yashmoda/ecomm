package com.cf.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(path = "/add")
    public ResponseEntity<String> RegisterUser(@RequestBody Register register)
    {
        int insert_response = registerService.add(register);
        if(insert_response == 0)
        {
            return new ResponseEntity<String>("The user has been registered.", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("The user has been updated.", HttpStatus.OK);
        }
    }
}
