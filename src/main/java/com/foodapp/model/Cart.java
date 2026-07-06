package com.foodapp.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    // Stores Menu ID and Quantity
    private Map<Integer, Integer> items = new HashMap<>();

    // Add item to cart
    public void addItem(int menuId) {

        if(items.containsKey(menuId)) {

            items.put(menuId, items.get(menuId) + 1);

        } else {

            items.put(menuId, 1);

        }
    }

    // Remove item
    public void removeItem(int menuId) {

        items.remove(menuId);

    }

    // Update quantity
    public void updateItem(int menuId, int quantity) {

        items.put(menuId, quantity);

    }

    // Get all items
    public Map<Integer, Integer> getItems() {

        return items;

    }
}