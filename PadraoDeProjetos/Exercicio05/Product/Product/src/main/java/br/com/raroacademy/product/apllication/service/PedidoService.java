package br.com.raroacademy.product.apllication.service;

import br.com.raroacademy.product.apllication.usecase.ProcessOrderUseCase;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoRequestDTO;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    ProcessOrderUseCase processOrderUseCase;

   public List<PedidoResponseDTO> processOrder (List<PedidoRequestDTO> pedidos){
       return processOrderUseCase.execute(pedidos);
   }
}