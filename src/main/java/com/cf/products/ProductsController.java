package com.cf.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/com/cf/product")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Products>> getAllProducts()
    {
        List<Products> products = productsService.getAllProducts();
        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Products> getProductById(@RequestParam int id)
    {
        Products products = productsService.getProductById(id);
        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }
}
