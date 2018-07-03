package com.cf.admin;

import com.cf.orders.Order;
import com.cf.products.Products;
import com.cf.signup.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public List<Register> getAllUsers()
    {
        List<Register> register = adminDAO.getAllUsers();
        return register;
    }

    public Register getUserByPhone(String phone)
    {
        Register register = adminDAO.getUserByPhone(phone);
        return register;
    }

    public Register getUserByEmail(String email)
    {
        Register register = adminDAO.getUserByEmail(email);
        return register;
    }

    public void addProducts(Products products)
    {
        adminDAO.addProducts(products);
    }

    public List<Order> allOrders()
    {
        List<Order> orders = adminDAO.allOrders();
        return orders;
    }

    public List<Order> completedOrders()
    {
        List<Order> orders = adminDAO.completedOrders();
        return orders;
    }

    public List<Order> allCancelledOrders()
    {
        List<Order> orders = adminDAO.allCancelledOrders();
        return orders;
    }

    public List<Order> pendingOrders()
    {
        List<Order> orders = adminDAO.pendingOrders();
        return orders;
    }

    public Order getOrderById(int id)
    {
        Order order = adminDAO.getOrderById(id);
        return order;
    }

}

