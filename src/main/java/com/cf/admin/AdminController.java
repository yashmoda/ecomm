package com.cf.admin;

import com.cf.orders.Order;
import com.cf.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(path = "/add_products")
    public ResponseEntity addProducts(@RequestBody Products products)
    {
        adminService.addProducts(products);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/all_orders")
    public ResponseEntity<List<Order>> allOrders()
    {
        List<Order> orders = adminService.allOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping(path = "/cancelled_orders")
    public ResponseEntity<List<Order>> allCancelledOrders()
    {
        List<Order> orders = adminService.allCancelledOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping(path = "/completed_orders")
    public ResponseEntity<List<Order>> completedOrders()
    {
        List<Order> orders = adminService.completedOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping(path = "/pending_orders")
    public ResponseEntity<List<Order>> pendingOrders()
    {
        List<Order> orders = adminService.pendingOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping(path = "/get_order_by_id")
    public ResponseEntity<Order> getOrderById(@RequestParam int id)
    {
        Order order = adminService.getOrderById(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
