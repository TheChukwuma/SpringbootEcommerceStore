package com.babbage.springbootwebstore.serviceImpl;

import com.babbage.springbootwebstore.dto.UserRegistrationDTO;
import com.babbage.springbootwebstore.model.User;
import com.babbage.springbootwebstore.repository.UserRepository;
import com.babbage.springbootwebstore.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getEmail(), registrationDTO.getPassword(), registrationDTO.getPhone());

        return userRepository.save(user);
    }

    @Override
    public boolean login(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user == null){
            return false;
        }
        return true;
    }

}
