package com.project.shoppingApplication.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document(collection = "Cart")
public class Cart {

    private String id;

    public String status; //pending, ordered

    public String userName;

    public HashMap<String, Product> products;

    public HashMap<String, Integer> productQuantities;
    
	
}
