package com.study.store.service;

import com.study.store.dto.ProductRequest;
import com.study.store.dto.ProductResponse;
import com.study.store.exceptions.ProductNotFoundException;
import com.study.store.model.Product;
import com.study.store.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id){
        Product product = findProductById(id);
        return toResponse(product);
    }

    @Transactional
    public ProductResponse create(ProductRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        Product savedProduct = productRepository.save(product);

        return toResponse(savedProduct);
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = findProductById(id);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        Product updatedProduct = productRepository.save(product);

        return toResponse(updatedProduct);
    }

    @Transactional
    public void delete(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
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
