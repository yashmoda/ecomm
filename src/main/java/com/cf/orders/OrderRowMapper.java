package com.cf.orders;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper {

    @Override
    public Order mapRow(ResultSet row, int rowNum) throws SQLException
    {
        Order order = new Order();
        order.setAddress_id(row.getInt("address_id"));
        order.setId(row.getInt("id"));
        order.setPhone(row.getString("phone"));
        order.setProduct_id(row.getInt("product_id"));
        order.setDelivery_status(row.getString("delivery_status"));
        order.setOrder_status(row.getString("order_status"));
        return order;
    }
}
