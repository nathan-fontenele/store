package com.study.store.controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController
{
    @GetMapping
    public List<String> List() {
        return List.of("Notebook", "Mouse", "Keyboard");
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id){
        return "Product ID: " + id;
    }

    @PostMapping
    public String create(@RequestBody String product){
        return "Created product: " + product;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody String product){
        return "Updated product ID" + id + ": " + product;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "Removed product id: " + id;
    }
}
