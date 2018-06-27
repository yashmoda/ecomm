package com.cf.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cf.signup.Register;

import java.util.List;

@Controller
@RequestMapping("/com/cf/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/all_users")
    public ResponseEntity<List<Register>> getAllUsers()
    {
        List<Register> register = adminService.getAllUsers();
        return new ResponseEntity<List<Register>>(register, HttpStatus.OK);
    }

    @GetMapping(path = "/get_user_by_phone")
    public ResponseEntity<Register> getUserByPhone(@RequestParam String phone)
    {
        Register register = adminService.getUserByPhone(phone);
        return new ResponseEntity<Register>(register, HttpStatus.OK);
    }

    @GetMapping(path = "/get_user_by_email")
    public ResponseEntity<Register> getUserByEmail(@RequestParam String email)
    {
        Register register = adminService.getUserByEmail(email);
        return new ResponseEntity<Register>(register, HttpStatus.OK);
    }
}
