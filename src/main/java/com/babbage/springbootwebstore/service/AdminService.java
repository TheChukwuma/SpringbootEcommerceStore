package com.babbage.springbootwebstore.service;

import com.babbage.springbootwebstore.dto.UserRegistrationDTO;
import com.babbage.springbootwebstore.model.Admin;

public interface AdminService {

    boolean loginAdmin(String email, String password);

    Admin registerAdmin(UserRegistrationDTO userRegistrationDTO);
}
