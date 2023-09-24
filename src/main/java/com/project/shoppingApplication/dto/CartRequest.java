package com.project.shoppingApplication.dto;

import java.util.List;

import com.project.shoppingApplication.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest{

    private String customerId;
    private List<Item> items;
}