package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Restaurant;

public interface RestaurantDAO {

    // ➕ Add new restaurant
    int addRestaurant(Restaurant restaurant);

    // 🔍 Get restaurant by ID
    Restaurant getRestaurantById(int restaurantId);

    // 📋 Get all restaurants
    List<Restaurant> getAllRestaurants();

    // ✏️ Update restaurant
    int updateRestaurant(Restaurant restaurant);

    // ❌ Delete restaurant
    int deleteRestaurant(int restaurantId);
}
