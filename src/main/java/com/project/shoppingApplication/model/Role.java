package com.project.shoppingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Role")
public class Role {

	@Id
	private String id;
	
	private String role;  //Custormer , Seller 

}
