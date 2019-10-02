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
public class UserTransaction {
    
    private String userId;
    private Transaction transactions;

    public Transaction getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction transactions) {
        this.transactions = transactions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
