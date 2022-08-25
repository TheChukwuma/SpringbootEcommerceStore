package com.babbage.springbootwebstore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String category;
    private Long quantity;
    private Double price;
    private String image;
}
