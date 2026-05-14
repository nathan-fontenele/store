package com.study.store.dto;

import lombok.Getter;

import java.math.BigDecimal;

public class ProductResponse {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private BigDecimal price;

    @Getter
    private Integer quantity;

    public ProductResponse(Long id, String name, String description, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
