package com.project.shoppingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "User")
public class User {
	
    @Id
    private String id;

    public Role roleId;
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

}
