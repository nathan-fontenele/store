package com.study.store.service;

import com.study.store.dto.ProductRequest;
import com.study.store.dto.ProductResponse;
import com.study.store.exceptions.ProductNotFoundException;
import com.study.store.model.Product;
import com.study.store.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void deveCadastrarProdutoComSucesso() {
        // dado que temos uma requisição válida
        ProductRequest request = new ProductRequest();
        request.setName("Teclado Mecânico");
        request.setDescription("Teclado gamer RGB");
        request.setPrice(new BigDecimal("350.00"));
        request.setQuantity(10);

        // e o repositório vai simular o salvamento retornando o produto com ID
        Product produtoSalvo = new Product();
        produtoSalvo.setName(request.getName());
        produtoSalvo.setDescription(request.getDescription());
        produtoSalvo.setPrice(request.getPrice());
        produtoSalvo.setQuantity(request.getQuantity());

        when(productRepository.save(any(Product.class))).thenReturn(produtoSalvo);

        // quando chamarmos o create
        ProductResponse response = productService.create(request);

        // então o retorno deve refletir os dados enviados
        assertThat(response.getName()).isEqualTo("Teclado Mecânico");
        assertThat(response.getDescription()).isEqualTo("Teclado gamer RGB");
        assertThat(response.getPrice()).isEqualByComparingTo("350.00");
        assertThat(response.getQuantity()).isEqualTo(10);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoEncontrado(){
        // dado que o repositório não encontra nenhum produto com esse ID
        when(productRepository.findById(12L)).thenReturn(Optional.empty());

        // então deve lançar ProductNotFoundException ao buscar
        assertThatThrownBy(() -> productService.findById(12L))
                .isInstanceOf(ProductNotFoundException.class);
    }
}
