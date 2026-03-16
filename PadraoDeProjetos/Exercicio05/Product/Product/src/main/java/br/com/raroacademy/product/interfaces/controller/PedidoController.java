package br.com.raroacademy.product.interfaces.controller;


import br.com.raroacademy.product.apllication.service.PedidoService;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoRequestDTO;
import br.com.raroacademy.product.interfaces.dto.pedido.PedidoResponseDTO;
import br.com.raroacademy.product.interfaces.dto.product.ProductResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public List<PedidoResponseDTO> makeOrder (@RequestBody List<PedidoRequestDTO> pedidos){
        List<PedidoResponseDTO> listOrder = pedidoService.processOrder(pedidos);
        return listOrder;
    }
}