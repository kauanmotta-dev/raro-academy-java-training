package br.com.raroacademy.product.infrastructure.adapter;

import br.com.raroacademy.product.domain.repository.ProductRepository;
import br.com.raroacademy.product.infrastructure.client.ProductClient;
import br.com.raroacademy.product.interfaces.dto.product.ProductRequestDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    @Autowired
    ProductClient productClient;

    @Override
    public List<ProductResponseDTO> getProductsByFilter(ProductRequestDTO productRequestDTO) {
        ProductResponseListDTO responseListDTO = productClient.getProductsByCategory(productRequestDTO.getCategory());
        return responseListDTO.getProducts().stream()
                .filter(product -> product.getPrice() <= productRequestDTO.getPrice())
                .filter(product -> product.getStock() >= productRequestDTO.getStock())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductResponseDTO> getProductByID(int id) {

        try {
            ProductResponseDTO productResponseDTO = productClient.getProductByID(id);
            return Optional.of(productResponseDTO);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}