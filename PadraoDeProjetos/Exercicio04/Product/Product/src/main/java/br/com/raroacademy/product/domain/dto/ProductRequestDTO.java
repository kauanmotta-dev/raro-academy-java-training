package br.com.raroacademy.product.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {

    @Positive(message = "O valor deve ser maior que Zero")
    @Max(value = 2000, message = "O valor deve ser menor que Dois Mil")
    private double price;
    @Positive(message = "O valor deve ser maior que Zero")
    private int stock;
    @NotBlank(message = "A categoria é obrigatória")
    private String category;

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
}
