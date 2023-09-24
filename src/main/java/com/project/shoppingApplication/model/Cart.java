package com.project.shoppingApplication.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
@Document(collection = "Cart")
public class Cart {

	@Id
    private String id;

    public String status; //pending, ordered

    @NonNull
    public String userId;

    @DBRef      // to store the reference of another Documents
    @NonNull
    private List<Item> item;
    
//    public HashMap<String, Integer> productId;
    
	
}
