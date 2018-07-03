package com.cf.admin;

import com.cf.orders.Order;
import com.cf.orders.OrderRowMapper;
import com.cf.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cf.signup.Register;
import com.cf.signup.RegisterRowMapper;

import java.util.List;

@Transactional
@Repository
public class AdminDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Register> getAllUsers()
    {
        String query = "SELECT * FROM register";
        RowMapper<Register> mapper = new RegisterRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public Register getUserByPhone(String phone)
    {
        String query = "SELECT * FROM register where phone = ?";
        RowMapper<Register> mapper = new RegisterRowMapper();
        return jdbcTemplate.queryForObject(query, mapper, phone);
    }

    public Register getUserByEmail(String email)
    {
        String query = "SELECT * FROM register where email = ?";
        RowMapper<Register> mapper = new RegisterRowMapper();
        return jdbcTemplate.queryForObject(query, mapper, email);
    }

    public void addProducts(Products products)
    {
        String query = "INSERT INTO products(name, description, price) values (?, ?, ?)";
        jdbcTemplate.update(query, products.getName(), products.getDescription(), products.getPrice());
    }

    public List<Order> allCancelledOrders()
    {
        String query = "SELECT * FROM ORDERS WHERE order_status = -1";
        RowMapper<Order> mapper = new OrderRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public List<Order> allOrders()
    {
        String query = "SELECT * FROM orders";
        RowMapper<Order> mapper = new OrderRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public List<Order> completedOrders()
    {
        String query = "SELECT * FROM orders WHERE delivery_status = 1";
        RowMapper<Order> mapper = new OrderRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public List<Order> pendingOrders()
    {
        String query = "SELECT * FROM orders WHERE delivery_status = 0";
        RowMapper<Order> mapper = new OrderRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public Order getOrderById(int id)
    {
        String query = "SELECT * FROM orders WHERE id = ?";
        RowMapper<Order> mapper = new OrderRowMapper();
        return jdbcTemplate.queryForObject(query, mapper, id);
    }
}
