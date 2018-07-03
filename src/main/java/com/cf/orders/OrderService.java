package com.cf.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void createOrder(Order order)
    {
        orderDAO.createOrder(order);
    }

    public void updateOrder(Order order)
    {
        orderDAO.updateOrder(order);
    }

    public void cancelOrder(Order order)
    {
        orderDAO.cancelOrder(order);
    }

    public List<Order> getAllOrder(String phone)
    {
        List<Order> orders = orderDAO.getAllOrder(phone);
        return orders;
    }

    public void updateDeliveryStatus(Order order)
    {
        orderDAO.updateDeliveryStatus(order);
    }
}
