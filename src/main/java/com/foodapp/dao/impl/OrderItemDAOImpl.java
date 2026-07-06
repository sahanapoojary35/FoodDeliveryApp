package com.foodapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.OrderItemDAO;
import com.foodapp.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    // Add Order Item
    @Override
    public int addOrderItem(OrderItem orderItem) {

        // JDBC code will be added later
        System.out.println("addOrderItem() called");

        return 0;
    }

    // Get Order Item by ID
    @Override
    public OrderItem getOrderItemById(int orderItemId) {

        // JDBC code will be added later
        System.out.println("getOrderItemById() called");

        return null;
    }

    // Get all Order Items of an Order
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        // JDBC code will be added later
        System.out.println("getOrderItemsByOrderId() called");

        return new ArrayList<>();
    }

    // Update Order Item
    @Override
    public int updateOrderItem(OrderItem orderItem) {

        // JDBC code will be added later
        System.out.println("updateOrderItem() called");

        return 0;
    }

    // Delete Order Item
    @Override
    public int deleteOrderItem(int orderItemId) {

        // JDBC code will be added later
        System.out.println("deleteOrderItem() called");

        return 0;
    }
}
