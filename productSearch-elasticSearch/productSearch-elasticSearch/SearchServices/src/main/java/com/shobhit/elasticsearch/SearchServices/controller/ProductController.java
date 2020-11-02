package com.shobhit.elasticsearch.SearchServices.controller;

import java.util.Map;

import com.shobhit.elasticsearch.SearchServices.dao.ProductDao;
import com.shobhit.elasticsearch.SearchServices.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productDao.getProductById(id);
    }   

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productDao.createProduct(product);

    }



}
