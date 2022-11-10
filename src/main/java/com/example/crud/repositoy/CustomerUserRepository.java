package com.example.crud.repositoy;

import com.example.crud.model.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerUserRepository extends JpaRepository<CustomerUser,Long> {
     
}
