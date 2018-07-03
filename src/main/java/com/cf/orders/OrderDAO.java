package com.cf.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createOrder(Order order)
    {
        String query = "INSERT INTO orders (address_id, product_id, phone) values (?, ?, ?)";
        jdbcTemplate.update(query, order.getAddress_id(), order.getProduct_id(), order.getPhone());
    }

    public void updateOrder(Order order)
    {
        String query = "UPDATE orders SET address_id = ?, product_id = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(query, order.getAddress_id(), order.getProduct_id(), order.getPhone(), order.getId());
    }

    public void cancelOrder(Order order)
    {
        String query = "UPDATE orders SET order_status = -1 WHERE id = ?";
        jdbcTemplate.update(query, order.getId());
    }

    public void updateDeliveryStatus(Order order)
    {
        String query = "UPDATE orders SET delivery_status = 1 where id = ?";
        jdbcTemplate.update(query, order.getId());
    }

    public List<Order> getAllOrder(String phone)
    {
        String query = "SELECT * FROM orders where phone = ?";
        RowMapper<Order> orderRowMapper = new OrderRowMapper();
        return jdbcTemplate.query(query, orderRowMapper, phone);
    }
}
