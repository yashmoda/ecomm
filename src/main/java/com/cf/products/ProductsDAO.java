package com.cf.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Products> getAllProducts()
    {
        String query = "select * from products";
        RowMapper<Products> mapper = new ProductsRowMapper();
        return jdbcTemplate.query(query, mapper);
    }

    public Products getProductById(int id)
    {
        String query = "select * from products where id = ?";
        RowMapper<Products> mapper = new ProductsRowMapper();
        return jdbcTemplate.queryForObject(query, mapper, id);
    }

}
