package com.babbage.springbootwebstore.serviceImpl;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.model.Products;
import com.babbage.springbootwebstore.repository.ProductRepository;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Products> getAllProduct() {
          return productRepo.findAll();
    }

    @Override
    public Products save(ProductDTO productDTO) {
        Products product = new Products(productDTO.getName(), productDTO.getCategory(), productDTO.getPrice(), productDTO.getQuantity(), productDTO.getImage());
        return productRepo.save(product);
    }

    @Override
    public Products getProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Products updateProduct(Products product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }
}
