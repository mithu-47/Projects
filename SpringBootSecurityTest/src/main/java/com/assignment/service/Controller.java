/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.service;

import com.assignment.dao.TransactionDAO;
import com.assignment.dao.UsersDAO;
import com.assignment.model.UserTransaction;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
public class Controller {

    @Autowired
    public TransactionDAO dao;

    @GetMapping(value = "/getUserList", produces = "application/json")
    public HashMap getUserList() {
        HashMap userList = new HashMap();
        userList.put("users", UsersDAO.getUserList());
        return userList;
    }

    @PostMapping(value = "/getMyTransactions", produces = "application/json", consumes = "application/json")
    public HashMap getMyTransactions(@RequestBody UserTransaction userTxn) {
        HashMap userList = new HashMap();
        userList.put("transactions", dao.getMyTransaction(userTxn.getUserId()));
        return userList;
    }

    @PostMapping(value = "/insertMyTransaction", produces = "application/json", consumes = "application/json")
    public HashMap insertMyTransaction(@RequestBody UserTransaction userTxn) {
        HashMap userList = new HashMap();
        int responseRowCount = dao.insertMyTransaction(userTxn);
        if (responseRowCount > 0) {
            userList.put("success", "Data inserted successfully");
        }
        return userList;
    }

    @PostMapping(value = "/getMyReport", produces = "application/json", consumes = "application/json")
    public HashMap getMyReport(@RequestBody UserTransaction userTxn) {
        HashMap userList = new HashMap();
        HashMap report = new HashMap();
        report.put("YTD", "");
        report.put("MTD", "");
        userList.put("Report", report);
        return userList;
    }
}
