package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.model.Products;
import com.babbage.springbootwebstore.service.AdminService;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping ()
public class ProductController {

    private AdminService adminService;
    private ProductService productService;

    public ProductController(AdminService adminService, ProductService productService) {
        this.adminService = adminService;
        this.productService = productService;
    }

    //handler method to handle list product and return mode amd view

    @GetMapping("/products")
    public String listProducts(Model model, HttpSession session){
        model.addAttribute("products", productService.getAllProduct());
        session.setAttribute("all-products",productService.getAllProduct() );

        return "products";
    }

    @ModelAttribute("product")
    public ProductDTO productDTO(){
        return new ProductDTO();
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") ProductDTO productDTO){
        productService.save(productDTO);
        System.out.println(productDTO);
        return "redirect:/add-produc";
    }

    @GetMapping("/add-produc")
    public String showAddProductPage(Model model){
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
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product")Products product){
        productService.updateProduct(product, id);
         return "redirect:/products";
    }

    //handler method to handle product delete
    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }




}
