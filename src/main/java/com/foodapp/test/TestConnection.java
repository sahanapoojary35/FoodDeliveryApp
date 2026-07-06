package com.foodapp.test;

import java.sql.Connection;

import com.foodapp.DBUtil.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {

            System.out.println("Connection Successful.");

        } else {

            System.out.println("Connection Failed.");
        }

    }

}