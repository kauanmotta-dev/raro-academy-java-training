package br.com.raroacademy.product.interfaces.dto.pedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PedidoRequestDTO {

    @Min(value = 1, message = "The quantity must be greather than zero")
    private int quantity;
    @NotNull(message = "Product ID is required")
    private int productID;


    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(int quantity, int productID) {
        this.quantity = quantity;
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
}