package com.example.crud.service;

import com.example.crud.model.CustomerUser;
import com.example.crud.repositoy.CustomerUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CustomerUserServiceImpl implements CustomerUserService {
    private final CustomerUserRepository customerUserRepository;
    @Autowired
    public CustomerUserServiceImpl(CustomerUserRepository customerUserRepository) {
        this.customerUserRepository = customerUserRepository;
    }

    @Override
    public CustomerUser findById (Long id){
        log.info("IN CustomerUserServiceImpl findById {}", id);
        return customerUserRepository.getReferenceById(id);
    }
    @Override
    public List<CustomerUser> findAll(){
        log.info("IN CustomerUserServiceImpl findAll");
        return customerUserRepository.findAll();
    }
    @Override
    public CustomerUser saveUser(CustomerUser customerUser){
        log.info("IN CustomerUserServiceImpl delete {}", customerUser);
        return customerUserRepository.save(customerUser);
    }

    @Override
    public void deleteUser(Long id){
        log.info("IN CustomerUserServiceImpl delete {}", id);
        customerUserRepository.deleteById(id);
    }
}
