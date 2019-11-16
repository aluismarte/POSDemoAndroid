package com.alsjava.courses.posdemoandroid.model.communication.request;

import com.alsjava.courses.posdemoandroid.model.api.BuyAPI;

import java.util.List;

/**
 * Created by aluis on 11/9/19.
 */
public class InvoiceRequest extends Request {

    private List<BuyAPI> buys;
    private double total;
}
