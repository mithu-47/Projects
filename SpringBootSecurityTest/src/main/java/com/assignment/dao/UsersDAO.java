/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.dao;

import com.assignment.model.User;
import com.assignment.model.Users;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class UsersDAO {

    public static ArrayList getUserList() {
        ArrayList<User> userList = new ArrayList<>();
        // TODO :  Fetch from DB and set user list in USERS class
        //HardCoding the users
        User user = new User(1, "abc");
        userList.add(user);
        return userList;
    }
}
