package com.study.store.service;

import com.study.store.dto.ProductRequest;
import com.study.store.dto.ProductResponse;
import com.study.store.model.Product;
import com.study.store.repository.ProductReposity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductReposity productRepository;

    public ProductService(ProductReposity productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id){
        Product product = findProductById(id);
        return toResponse(product);
    }

    public ProductResponse create(ProductRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        Product savedProduct = productRepository.save(product);

        return toResponse(savedProduct);
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = findProductById(id);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        Product updatedProduct = productRepository.save(product);

        return toResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    private ProductResponse toResponse(Product product)
    {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
