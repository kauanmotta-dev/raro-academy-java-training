package br.com.raroacademy.product.domain.repository;

import br.com.raroacademy.product.interfaces.dto.pedido.PedidoResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductRequestDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductResponseDTO> getProductsByFilter (ProductRequestDTO ProductRequestDTO);

    Optional<ProductResponseDTO> getProductByID (int id);
}