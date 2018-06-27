package com.cf.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AddressDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addAddress(Address address)
    {
        String query = "INSERT INTO address(address, phone) values (?, ?)";
        jdbcTemplate.update(query, address.getAddress(), address.getPhone());
    }
}
