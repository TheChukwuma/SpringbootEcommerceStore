package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.dto.ProductDTO;
import com.babbage.springbootwebstore.dto.UserLoginDTO;
import com.babbage.springbootwebstore.model.Admin;
import com.babbage.springbootwebstore.model.Products;
import com.babbage.springbootwebstore.service.AdminService;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;


//    @GetMapping("")
//    public String showAdminLoginPage(Model model){
//        model.addAttribute("admin",new Admin());
//        return "admin";
//    }
//
//    @PostMapping("/products")
//    public String adminLoginBeingSuccessful(){
//        return "/products";
//    }
    //handler method to handle list product and return mode amd view
    @GetMapping()
    public String showAdminPage(Model model){
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @PostMapping()
    public String loginAdminToWebsite(@ModelAttribute("admin") Admin personnel, HttpSession session, Model model){
        if(adminService.loginAdmin(personnel.getEmail(), personnel.getPassword())){
            session.setAttribute("adminSession", personnel.getEmail());
            return "products";
        }
        model.addAttribute("error","Invalid username or password!");
        return "admin";
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProduct());
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
        return "products";
    }

//    @GetMapping("redirect")
//    public RedirectView redirect(RedirectAttributes attributes){
//        return new RedirectView("products.html");
//    }

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
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product")ProductDTO productDTO, Model model){
       //get product from database by id
        Products existingProduct = productService.getProductById(id);
        existingProduct.setName(productDTO.getName());
        existingProduct.setCategory(productDTO.getCategory());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        //save updated product
        productService.updateProduct(existingProduct);
        //return listProducts(model);
        return "redirect:/products";
    }

    //handler method to handle product delete
    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }



}
