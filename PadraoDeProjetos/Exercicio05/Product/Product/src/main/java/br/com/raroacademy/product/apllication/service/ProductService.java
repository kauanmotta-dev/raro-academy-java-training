package br.com.raroacademy.product.apllication.service;

import br.com.raroacademy.product.apllication.usecase.GetProductsUseCase;
import br.com.raroacademy.product.interfaces.dto.product.ProductRequestDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    GetProductsUseCase getProductsUseCase;

    public List<ProductResponseDTO> getProducts(ProductRequestDTO request){
        return getProductsUseCase.execute(request);
    }
}