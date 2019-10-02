/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.model;

/**
 *
 * @author LENOVO
 */
public class Transaction {

    public Transaction(String invoiceId, String invoiceDate, String amount) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
    }
    
    private String invoiceId;
    private String invoiceDate;
    private String amount;
    

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
