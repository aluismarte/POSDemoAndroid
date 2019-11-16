package com.alsjava.courses.posdemoandroid.model.api;

/**
 * Created by aluis on 11/16/19.
 */
public class ReportAPI {

    private int invoiceQuantity;
    private double totalSales;

    public int getInvoiceQuantity() {
        return invoiceQuantity;
    }

    public void setInvoiceQuantity(int invoiceQuantity) {
        this.invoiceQuantity = invoiceQuantity;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}
