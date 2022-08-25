package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.dto.UserRegistrationDTO;
import com.babbage.springbootwebstore.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping()
    public String showRegistrationForm(){
        return "user-registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO registrationDTO){
            userService.save(registrationDTO);
        return "redirect:/user-registration?success";
    }



}
