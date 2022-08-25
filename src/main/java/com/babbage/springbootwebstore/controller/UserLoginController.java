package com.babbage.springbootwebstore.controller;

import com.babbage.springbootwebstore.dto.UserLoginDTO;
import com.babbage.springbootwebstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user-login")
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping()
    public String showLoginForm(Model model){
        model.addAttribute("user",new UserLoginDTO());
        return "user-login";
    }

    @PostMapping
    public String loginUserAccount(@ModelAttribute("user") UserLoginDTO userLoginDTO, HttpSession session, Model model) {
        if(userService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword())){
            session.setAttribute("auth", userLoginDTO.getEmail());
            return "redirect:/index";
        }
        model.addAttribute("error","Invalid username or password!");
        return "user-login";
    }

}
