package com.cf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class create_tables {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(path = "/create_tables")
    public ResponseEntity createTables()
    {

        String register_query = "CREATE TABLE register (first_name VARCHAR(45) NOT NULL, last_name VARCHAR(45) NOT NULL, " +
                "email VARCHAR(512) NOT NULL UNIQUE, phone VARCHAR(15) NOT NULL, password VARCHAR(45) NOT NULL, " +
                "PRIMARY KEY(phone))";
        jdbcTemplate.update(register_query);

        String product_query = "CREATE TABLE products (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(512) NOT NULL, " +
                "description VARCHAR(10000) NOT NULL, price INT NOT NULL, PRIMARY KEY(id))";
        jdbcTemplate.update(product_query);

        String address_query = "CREATE TABLE address (id INT NOT NULL AUTO_INCREMENT, phone VARCHAR(15), " +
                "address VARCHAR(10000) NOT NULL, FOREIGN KEY (phone) REFERENCES register (phone), PRIMARY KEY (id))";
        jdbcTemplate.update(address_query);

        String order_query = "CREATE TABLE orders (id INT NOT NULL AUTO_INCREMENT, address_id INT, product_id INT, " +
                "delivery_status INT NOT NULL DEFAULT 0, order_status INT NOT NULL DEFAULT 0, phone varchar (45)," +
                "FOREIGN KEY (address_id) REFERENCES address(id), FOREIGN KEY (product_id) REFERENCES products(id), " +
                "PRIMARY KEY (id), FOREIGN KEY (phone) REFERENCES register(phone))";
        jdbcTemplate.update(order_query);

        String favorites_query = "CREATE TABLE favorites (id int not null auto_increment, " +
                "product_id int not null, phone varchar(45), PRIMARY KEY (id), " +
                "FOREIGN KEY (product_id) REFERENCES products(id), FOREIGN KEY (phone) REFERENCES register(phone))";
        jdbcTemplate.update(favorites_query);

        return new ResponseEntity(HttpStatus.OK);
    }
}
