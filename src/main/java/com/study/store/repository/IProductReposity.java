package com.study.store.repository;
import com.study.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public interface IProductReposity extends JpaRepository<Product, Long> {
    @Override
    public <S extends Product> S save(S entity);

    @Override
    public Optional<Product> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public void deleteById(Long aLong) ;

    @Override
    public List<Product> findAll() ;
}
