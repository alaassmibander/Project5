package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Store {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty
    private String name;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(mappedBy = "store")
    private List<Book> books;

    @ManyToMany(mappedBy = "stores")
    @JsonIgnore
    private List<Customer> customers;

}
