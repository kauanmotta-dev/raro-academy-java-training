package br.com.raroacademy.product.infrastructure.client;

import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "productClient", url = "https://dummyjson.com")
public interface ProductClient {

    // Solicitado em exercicio "/products/{category}"
    //Porém DummyJSON não tem acesso a esse endpoint.
    @GetMapping("/products/category/{category}")
    ProductResponseListDTO getProductsByCategory(@PathVariable("category") String category);

    @GetMapping("/products/{id}")
    ProductResponseDTO getProductByID(@PathVariable("id") int id);
}