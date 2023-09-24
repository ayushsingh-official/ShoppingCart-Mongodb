package com.project.shoppingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document(collection = "User")
public class Product {

	@Id
	private String id;

	public String productName;
	public String productCode;

	public int price = 0;

	private int stock = 1000;

}
