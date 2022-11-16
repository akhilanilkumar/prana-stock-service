package com.prana.stock.sales.model;

public enum PaymentMode {

    CASH("CASH"),
    CARD("CARD"),
    UPI("UPI");

    public final String label;

    private PaymentMode(String label) {
        this.label = label;
    }
}
