package com.cf.address;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper {
    @Override
    public Address mapRow(ResultSet row, int rowNum) throws SQLException
    {
        Address address = new Address();
        address.setAddress(row.getString("address"));
        address.setId(row.getInt("id"));
        address.setPhone(row.getString("phone"));
        return address;
    }
}
