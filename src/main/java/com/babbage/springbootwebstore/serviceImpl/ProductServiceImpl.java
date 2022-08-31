package com.babbage.springbootwebstore.serviceImpl;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.model.Products;
import com.babbage.springbootwebstore.repository.ProductRepository;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepo;



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
    public Products updateProduct(Products product, Long id) {
        Products existingProduct = productRepo.findById(id).get();
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        //save updated product
        System.out.println(existingProduct);
        return productRepo.save(existingProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }
}
