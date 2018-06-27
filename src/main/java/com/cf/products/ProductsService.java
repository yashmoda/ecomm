package com.cf.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsDAO productsDAO;

    public List<Products> getAllProducts()
    {
        List<Products> products = productsDAO.getAllProducts();
        return products;
    }

    public Products getProductById(int id)
    {
        Products products = productsDAO.getProductById(id);
        return products;
    }
}
