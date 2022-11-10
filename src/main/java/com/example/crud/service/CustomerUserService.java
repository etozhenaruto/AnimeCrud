package com.example.crud.service;

import com.example.crud.model.CustomerUser;

import java.util.List;

public interface CustomerUserService {
    CustomerUser findById(Long id);
    List<CustomerUser> findAll();
    CustomerUser saveUser(CustomerUser customerUser);
    void deleteUser(Long id);
}
