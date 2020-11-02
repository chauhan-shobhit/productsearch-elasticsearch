package com.shobhit.elasticsearch.SearchServices.model;

import java.util.Map;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private String description;
    private String quantity;
    private float price;

    
}
