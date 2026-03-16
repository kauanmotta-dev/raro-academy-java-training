package br.com.raroacademy.product.service;

import br.com.raroacademy.product.domain.dto.ProductRequestDTO;
import br.com.raroacademy.product.domain.dto.ProductResponseDTO;
import br.com.raroacademy.product.domain.dto.ProductResponseListDTO;
import br.com.raroacademy.product.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductClient productClient;

    public List<ProductResponseDTO> getProducts(ProductRequestDTO request){
        ProductResponseListDTO responseList = productClient.getProductsByCategory(request.getCategory());
        return responseList.getProducts().stream()
                .filter(product -> product.getPrice() <= request.getPrice())
                .filter(product -> product.getStock() >= request.getStock())
                .collect(Collectors.toList());
    }
}
