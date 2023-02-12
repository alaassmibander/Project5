package com.example.project5.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer bookCount;

    @NotEmpty
    private String genre;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @JsonIgnore
    private Store store;

}