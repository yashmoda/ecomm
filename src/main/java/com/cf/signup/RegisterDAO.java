package com.cf.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class RegisterDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int check(String email, String phone)
    {
        String query_phone = "SELECT COUNT(*) FROM register where phone = ?";
        String query_email = "SELECT COUNT(*) FROM register where email = ?";
        int phone_count = jdbcTemplate.queryForObject(query_phone, Integer.class, phone);
        int email_count = jdbcTemplate.queryForObject(query_email, Integer.class, email);
        if(phone_count != 0 && email_count != 0)
        {
            return 300;
        }
        else if(phone_count != 0 || email_count !=0 )
        {
            if (phone_count != 0)
            {
                return 100;
            }
            else
            {
                return 200;
            }
        }
        else {
            return 0;
        }
    }

    public int add(Register register)
    {
        int flag = check(register.getEmail(), register.getPhone());
        if(flag == 300)
        {
            String query = "UPDATE register set first_name = ?, last_name = ?, password = ? WHERE phone = ? and email = ?";
            jdbcTemplate.update(query, register.getFirst_name(), register.getLast_name(), register.getPassword(), register.getPhone(), register.getEmail());
            return 400;
        }
        else if(flag == 100){
            String query = "UPDATE register set email = ?, first_name = ?, last_name = ?, password = ? WHERE phone = ?";
            jdbcTemplate.update(query, register.getEmail(), register.getFirst_name(), register.getLast_name(), register.getPassword(), register.getPhone());
            return 100;
        }
        else if(flag == 200){
            String query = "UPDATE register set first_name = ?, last_name = ?, password = ?, phone = ? WHERE email = ?";
            jdbcTemplate.update(query, register.getFirst_name(), register.getLast_name(), register.getPassword(), register.getPhone(), register.getEmail());
            return 200;
        }
        else {
            String query = "INSERT INTO register (first_name, last_name, email, phone, password) values (?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, register.getFirst_name(), register.getLast_name(), register.getEmail(), register.getPhone(), register.getPassword());
            return 0;
        }
    }
}
