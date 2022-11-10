package com.example.crud.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customerusers")
public class CustomerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    private int age;
    private int salary;
    private boolean activate;
}
