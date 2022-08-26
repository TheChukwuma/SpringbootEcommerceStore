package com.babbage.springbootwebstore.service;

import com.babbage.springbootwebstore.dto.UserRegistrationDTO;
import com.babbage.springbootwebstore.model.User;

public interface UserService {

    User save(UserRegistrationDTO registrationDTO);

    boolean login(String email, String password);
}
