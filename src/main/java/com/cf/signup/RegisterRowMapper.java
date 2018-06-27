package com.cf.signup;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterRowMapper implements RowMapper {
    @Override
    public Register mapRow(ResultSet row, int rowNum) throws SQLException
    {
        Register register = new Register();
        register.setFirst_name(row.getString("first_name"));
        register.setLast_name(row.getString("last_name"));
        register.setEmail(row.getString("email"));
        register.setPhone(row.getString("phone"));
        return register;
    }
}
