package com.cf.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/com/cf/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/create")
    public ResponseEntity createOrder(@RequestBody Order order)
    {
        orderService.createOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity updateOrder(@RequestBody Order order)
    {
        orderService.updateOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/cancel")
    public ResponseEntity cancelOrder(@RequestBody Order order)
    {
        orderService.cancelOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update_delivery")
    public ResponseEntity updateDeliveryStatus(@RequestBody Order order)
    {
        orderService.updateDeliveryStatus(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/my_orders")
    public ResponseEntity<List<Order>> showOrders(@RequestParam String phone)
    {
        List<Order> orders = orderService.getAllOrder(phone);
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
}
