package com.alsjava.courses.posdemoandroid.model.api;

import java.util.Date;
import java.util.List;

/**
 * Created by aluis on 11/16/19.
 */
public class InvoiceAPI {

    private String serial;
    private Date saleDateTime;
    private List<InvoiceDetailAPI> invoiceDetails;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(Date saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    public List<InvoiceDetailAPI> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetailAPI> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}
