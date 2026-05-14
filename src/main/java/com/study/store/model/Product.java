package com.study.store.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private Integer quantity;

    public Product(){}

    public Product(Long id, String name, String description, BigDecimal price, Integer quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
