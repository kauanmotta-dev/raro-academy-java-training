package br.com.raroacademy.product.apllication.usecase;

import br.com.raroacademy.product.domain.repository.ProductRepository;
import br.com.raroacademy.product.interfaces.dto.product.ProductRequestDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsUseCase {

        @Autowired
        ProductRepository productRepository;

        public List<ProductResponseDTO> execute(ProductRequestDTO request){
            return productRepository.getProductsByFilter(request);
        }
}