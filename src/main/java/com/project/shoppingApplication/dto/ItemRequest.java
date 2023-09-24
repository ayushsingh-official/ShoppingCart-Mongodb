package com.project.shoppingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest  {

	private String name;
	private Double value;
	private Integer quantity;
}