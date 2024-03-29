package com.alsjava.courses.posdemoandroid.model.communication.response;

import com.alsjava.courses.posdemoandroid.model.api.ProductAPI;

import java.util.List;

/**
 * Created by aluis on 11/9/19.
 */
public class ProductResponse extends Response {

    private List<ProductAPI> products;

    public List<ProductAPI> getProducts() {
        return products;
    }

    public void setProducts(List<ProductAPI> products) {
        this.products = products;
    }
}
