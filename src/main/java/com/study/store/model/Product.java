package com.study.store.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private BigDecimal price;

    @Setter
    private Integer quantity;

    public Product(){}

    public Product(String name, String description, BigDecimal price, Integer quantity){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
