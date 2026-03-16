package br.com.raroacademy.product.infrastructure.schedule;

import br.com.raroacademy.product.domain.entity.Pedido;
import br.com.raroacademy.product.domain.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalPedidoSchedule {

    private static final Logger logger = LoggerFactory.getLogger(TotalPedidoSchedule.class);
    @Autowired
    private PedidoRepository pedidoRepository;

    @Scheduled(fixedRate = 10000)
    public void calculateTotalOrders(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        StringBuilder scheduleBuild = new StringBuilder();

        int totalQuantityProducts = pedidoRepository.findAll().stream()
                .mapToInt(Pedido::getQuantity)
                .sum();

        scheduleBuild.append("\n========================================================\n");
        pedidos.forEach(pedido -> scheduleBuild.append(String.format(
                "Order ID %d: Product ID %d, Quantity %d \n",
                pedido.getId(),
                pedido.getProductId(),
                pedido.getQuantity())));
        scheduleBuild.append(String.format(
                "\nTotal orders: %d \n" +
                "Total quantity of products ordered in the database: %d",
                pedidos.size(), totalQuantityProducts));
        scheduleBuild.append("\n========================================================\n");

        logger.info(scheduleBuild.toString());
    }
}