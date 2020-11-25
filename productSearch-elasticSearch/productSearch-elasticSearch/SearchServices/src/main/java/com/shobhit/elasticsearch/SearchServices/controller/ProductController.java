package com.shobhit.elasticsearch.SearchServices.controller;

import java.util.List;
import java.util.Map;

import com.shobhit.elasticsearch.SearchServices.dao.ProductDao;
import com.shobhit.elasticsearch.SearchServices.model.Product;
import com.shobhit.elasticsearch.SearchServices.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productDao.createProduct(product), HttpStatus.CREATED);

    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable String id) {

        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable String id) {

        return new ResponseEntity<>(productService.updateProductById(id), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable String id) {

        productService.deleteProductById(id);

        return "item deleted";

    }

    @DeleteMapping
    public String deleteAllProducts() {

        productService.deleteAllProducts();
        return ("all items deleted");
    }

}
