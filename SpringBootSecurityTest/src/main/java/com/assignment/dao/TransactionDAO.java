/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.assignment.model.Transaction;
import com.assignment.model.UserTransaction;

/**
 *
 * @author LENOVO
 */
@Repository
public class TransactionDAO {
      
     @Autowired
     private JdbcTemplate jdbcTemplate;
     
     public Transaction getMyTransaction(String userId) {
          return jdbcTemplate.queryForObject(
                "select invoiceId,invoiceDate,amount from Transaction where userId = ?",
                new Object[]{userId},
                Transaction.class
        );
     }  
     
    public int insertMyTransaction(UserTransaction usrTxn) {
        return jdbcTemplate.update(
                "insert into Transaction (userId , invoiceId , invoiceDate , amount) values(?,?,?,?)",
                usrTxn.getUserId(), usrTxn.getTransactions().getInvoiceId(),usrTxn.getTransactions().getInvoiceDate(),usrTxn.getTransactions().getAmount());
    }
}
