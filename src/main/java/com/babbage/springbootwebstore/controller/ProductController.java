package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.model.Products;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //handler method to handle list product and return mode amd view
    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @ModelAttribute("product")
    public ProductDTO productDTO(){
        return new ProductDTO();
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute("product") ProductDTO productDTO){
        productService.save(productDTO);
        System.out.println(productDTO);
        return "redirect:/products?success";
    }

    @GetMapping("/add-product")
    public String showAddProduct(Model model){
        return "add-product";
    }

    @GetMapping("/products/new")
    public String createNewProduct(Model model){
        return  "add-product";
    }

    @GetMapping("/products/update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-update";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product")Products product, Model model){
       //get product from database by Id
        Products existingProduct;
        return "";

    }

}
