package com.babbage.springbootwebstore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private String image;


    public Products(String name, String category, Double price, Long quantity, String image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

}
