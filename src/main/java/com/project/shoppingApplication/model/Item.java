package com.project.shoppingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document(collection = "Item")
public class Item {

	@Id
	private String id;

	public String productName;
	
	public String quantity;

	public int price;

}
