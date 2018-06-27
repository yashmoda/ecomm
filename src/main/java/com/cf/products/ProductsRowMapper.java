package com.cf.products;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsRowMapper implements RowMapper {
    @Override
    public Products mapRow(ResultSet row, int rowNum) throws SQLException
    {
        Products products = new Products();
        products.setId(row.getInt("id"));
        products.setName(row.getString("name"));
        products.setDescription(row.getString("description"));
        products.setPrice(row.getInt("price"));
        return products;
    }
}
