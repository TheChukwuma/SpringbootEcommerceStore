package com.babbage.springbootwebstore.service;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.model.Products;

import java.util.List;

public interface ProductService {

    List<Products> getAllProduct();

    Products save(ProductDTO productDTO);

    Products getProductById(Long id);

    Products updateProduct(Products product);

    void deleteProductById(Long id);
}
