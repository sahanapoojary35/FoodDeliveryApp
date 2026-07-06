package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.OrderItem;

public interface OrderItemDAO {

    // Add a new order item
    int addOrderItem(OrderItem orderItem);

    // Get one order item using its ID
    OrderItem getOrderItemById(int orderItemId);

    // Get all items of one order
    List<OrderItem> getOrderItemsByOrderId(int orderId);

    // Update an order item
    int updateOrderItem(OrderItem orderItem);

    // Delete an order item
    int deleteOrderItem(int orderItemId);
}
