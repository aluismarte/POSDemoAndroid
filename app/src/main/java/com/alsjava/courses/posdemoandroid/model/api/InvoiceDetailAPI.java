package com.alsjava.courses.posdemoandroid.model.api;

/**
 * Created by aluis on 11/16/19.
 */
public class InvoiceDetailAPI {

    private ProductAPI product;
    private long quantity = 0L;
    private double price = 0;

    public ProductAPI getProduct() {
        return product;
    }

    public void setProduct(ProductAPI product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
