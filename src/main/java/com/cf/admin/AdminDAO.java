package com.cf.admin;

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
}
