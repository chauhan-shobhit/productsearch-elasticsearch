package com.shobhit.elasticsearch.SearchServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shobhit.elasticsearch.SearchServices.dao.ProductDao;
import com.shobhit.elasticsearch.SearchServices.dao.ProductRepository;
import com.shobhit.elasticsearch.SearchServices.model.Product;
import com.shobhit.elasticsearch.SearchServices.model.exception.ProductAlreadyExistException;
import com.shobhit.elasticsearch.SearchServices.model.exception.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.core.ipc.http.HttpSender.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

  @Autowired
  private ProductDao productDao;

  @Autowired
  private ProductRepository productRepository;

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProductService.class);

  /* Retrieve Product */

  public Product getProductById(String id) {

    if (!productRepository.findById(id).isEmpty()) {
      throw new ProductNotFoundException("Product with ID " + id + " not found");
    }

    return productRepository.findById(id).get();

  }

  public List<Product> getAllProducts() {

    List<Product> productsList = new ArrayList<>();

    Iterable<Product> prodIter = productRepository.findAll();

    prodIter.iterator().forEachRemaining(productsList::add);

    return productsList;

  }

  /* Update Product */

  public ResponseEntity<Object> updateProductById(String id, Product product) {
    Optional<Product> productOptional = productRepository.findById(id);

    if (!productOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    productRepository.save(product);

    return ResponseEntity.accepted().build();

  }

  /* Delete Product */

  public void deleteProductById(String id) {

    productRepository.deleteById(id);
  }

  public void deleteAllProducts() {
    productRepository.deleteAll();
  }

  /* Create Product */

  public Product createProduct(Product product) {

    Product savedProduct;// = productRepository.save(product);

    if (productRepository.findByName(product.getName(), null).isEmpty()) {

      savedProduct = productRepository.save(product);

    } else {

      throw new ProductAlreadyExistException("Product with name " + product.getName() + " already exists");

    }

    return savedProduct;

  }

}
