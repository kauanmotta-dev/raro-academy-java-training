package br.com.raroacademy.product.interfaces.controller;

import br.com.raroacademy.product.interfaces.dto.product.ProductRequestDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import br.com.raroacademy.product.apllication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> getProductsClient(@Validated @RequestBody ProductRequestDTO productRequestDTO){
        List<ProductResponseDTO> productsList = productService.getProducts(productRequestDTO);
        if (productsList.isEmpty()){
            String message = String.format(
                    "Produtos da %s com estoque maior ou igual a %d e valor menor que %.2f.",
                    productRequestDTO.getCategory(),
                    productRequestDTO.getStock(),
                    productRequestDTO.getPrice()
            );
            return ResponseEntity.status(404).body(message);
        }
        return ResponseEntity.ok(productsList);
    }
}