package br.com.raroacademy.product.interfaces.dto.pedido;

public class PedidoResponseDTO {

    private Long orderId;

    public PedidoResponseDTO(long id) {
        this.orderId = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}