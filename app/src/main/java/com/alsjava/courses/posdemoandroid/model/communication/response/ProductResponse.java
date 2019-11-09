package com.alsjava.courses.posdemoandroid.model.communication.response;

import com.alsjava.courses.posdemoandroid.model.Product;

import java.util.List;

/**
 * Created by aluis on 11/9/19.
 */
public class ProductResponse extends Response {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
