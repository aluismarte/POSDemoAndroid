package com.alsjava.courses.posdemoandroid.model.api;

/**
 * Created by aluis on 11/16/19.
 */
public class BuyAPI {

    private ProductAPI product;
    private int quantity;
    private double price;

    public ProductAPI getProduct() {
        return product;
    }

    public void setProduct(ProductAPI product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BuyAPI{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
