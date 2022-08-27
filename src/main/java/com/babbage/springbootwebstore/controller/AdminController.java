package com.babbage.springbootwebstore.controller;


import com.babbage.springbootwebstore.dto.UserLoginDTO;
import com.babbage.springbootwebstore.model.Admin;
import com.babbage.springbootwebstore.service.AdminService;
import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    public AdminController(AdminService adminService, ProductService productService) {
        this.adminService = adminService;
        this.productService = productService;
    }

//    @ModelAttribute("admin")
//    public Admin adminLogin(){
//        return new Admin();
//    }


    @GetMapping()
    public String showAdminPage(Model model){
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @PostMapping()
    public String loginAdminToWebsite(@ModelAttribute("admin") Admin personnel, HttpSession session, Model model){
        if(adminService.loginAdmin(personnel.getEmail(), personnel.getPassword())){
            session.setAttribute("adminSession", personnel.getEmail());
            return "redirect:products";
        }
        model.addAttribute("error","Invalid username or password!");
        return "admin";
    }
}
