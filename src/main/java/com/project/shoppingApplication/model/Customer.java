package com.project.shoppingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer")
public class Customer {

    @Id
    private String id;

    @NonNull
    private  String name;

    @NonNull
    private  String email;
}
