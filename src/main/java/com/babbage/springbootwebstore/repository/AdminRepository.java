package com.babbage.springbootwebstore.repository;

import com.babbage.springbootwebstore.model.Admin;
import com.babbage.springbootwebstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmailAndPassword(String email, String password);
}
