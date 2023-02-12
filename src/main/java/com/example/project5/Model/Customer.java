package com.example.project5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String email;

    @ManyToMany
    private List<Store> stores;
}