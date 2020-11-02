package com.shobhit.elasticsearch.SearchServices.dao;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shobhit.elasticsearch.SearchServices.model.Product;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private Product product;

    public Product getProductById(String id) {
        
        product = elasticsearchOperations.queryForObject( GetQuery , Product.class);
        return product;
        
	}

	public Product createProduct(Product product) {
        
        
       
	}


}
