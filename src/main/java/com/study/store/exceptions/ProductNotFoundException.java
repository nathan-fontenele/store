package com.study.store.exceptions;

public class ProductNotFoundException extends ResourceNotFoundException {
    public ProductNotFoundException(Long id) {
        super("Produto", id);
    }
}
