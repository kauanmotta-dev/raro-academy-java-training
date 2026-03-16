package br.com.raroacademy.product.apllication.usecase;

import br.com.raroacademy.product.domain.entity.Pedido;
import br.com.raroacademy.product.domain.repository.PedidoRepository;
import br.com.raroacademy.product.domain.repository.ProductRepository;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoRequestDTO;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessOrderUseCase {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public List<PedidoResponseDTO> execute(List<PedidoRequestDTO> pedidos) {
        return pedidos.stream()
                .map(this::validateOrder)
                .collect(Collectors.toList());
    }


    private PedidoResponseDTO validateOrder (PedidoRequestDTO pedido){
        Optional<ProductResponseDTO> pedidoValidate = productRepository.getProductByID(pedido.getProductID());

        if (pedido.getQuantity() <= 0){
            throw new ValidationException("Invalid quantity!");
        }

        if(pedidoValidate.isEmpty()){
            throw new ValidationException("Product with ID " + pedido.getProductID() + " not found!");
        }

        ProductResponseDTO product = pedidoValidate.get();

        if (pedido.getQuantity() > product.getStock()){
            throw new ValidationException("Insufficient stock!");
        }

        Pedido pedidoH2 = new Pedido(pedido.getQuantity(), pedido.getProductID());
        pedidoRepository.save(pedidoH2);

        return new PedidoResponseDTO(pedidoH2.getId());
    }
}