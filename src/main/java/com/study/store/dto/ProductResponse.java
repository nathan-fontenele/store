package com.study.store.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductResponse {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public ProductResponse(Long id, String name, String description, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
