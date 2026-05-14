package com.study.store.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotBlank(message="O campo nome é obrigatório")
    private String name;

    private String description;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    private BigDecimal price;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer quantity;

}
