package com.babbage.springbootwebstore.serviceImpl;

import com.babbage.springbootwebstore.dto.UserRegistrationDTO;
import com.babbage.springbootwebstore.model.Admin;
import com.babbage.springbootwebstore.repository.AdminRepository;
import com.babbage.springbootwebstore.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean loginAdmin(String email, String password) {
        Admin personnel =  adminRepository.findAdminByEmailAndPassword(email, password);
        if (personnel.getEmail().equals(email) && personnel.getPassword().equals(password)){
            return true;
        }
;        return false;
    }

    @Override
    public Admin registerAdmin(UserRegistrationDTO userRegistrationDTO) {
        return null;
    }
}
