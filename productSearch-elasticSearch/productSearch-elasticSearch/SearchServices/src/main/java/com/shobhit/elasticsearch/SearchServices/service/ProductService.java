package com.shobhit.elasticsearch.SearchServices.service;

import java.util.List;

import com.shobhit.elasticsearch.SearchServices.dao.ProductDao;
import com.shobhit.elasticsearch.SearchServices.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductDao productDao;

  public Product getProductById(String id) {

    return productDao.getProductById(id);

  }

  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }

  public Product updateProductById(String id) {
    return productDao.updateProductById(id);
  }

  public void deleteProductById(String id) {
    productDao.getProductById(id);
    // .map(itemToBeDeleted ->
    // productDao.deleteProductById(itemToBeDeleted)).then(ResponseEntity.ok());
  }

  public void deleteAllProducts() {
    productDao.deleteAllProducts();
  }

}
