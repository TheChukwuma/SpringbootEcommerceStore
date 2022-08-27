package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    final
    ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showHomePage(Model model, HttpSession session){
        model.addAttribute("products", productService.getAllProduct());

        session.setAttribute("product-page", productService.getAllProduct());
        return "index";
    }


    @GetMapping("/log-out")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
