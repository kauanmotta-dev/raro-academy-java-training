package br.com.raroacademy.product.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductResponseListDTO {

    @JsonProperty("products")
    private List<ProductResponseDTO> productResponseListDTO;

    public List<ProductResponseDTO> getProducts() {
        return productResponseListDTO;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.productResponseListDTO = products;
    }
}