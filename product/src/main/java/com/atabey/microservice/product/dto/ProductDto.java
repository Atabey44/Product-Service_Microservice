package com.atabey.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int productId;
    private String productName;
    private Double price;
    private Double salePrice;
    private Double saleRate;
}
