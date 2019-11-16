package com.alsjava.courses.posdemoandroid.model.api;

/**
 * Created by aluis on 11/9/19.
 */
public class ProductAPI {

    private String name;
    private long quantity;
    private double price;
    private String image; // Imagen en Base64

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
