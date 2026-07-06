package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Menu;

public interface MenuDAO {

    // Add a new menu item
    int addMenu(Menu menu);

    // Get one menu item by its ID
    Menu getMenuById(int menuId);

    // Get all menu items of a restaurant
    List<Menu> getAllMenusByRestaurant(int restaurantId);

    // Update a menu item
    int updateMenu(Menu menu);

    // Delete a menu item
    int deleteMenu(int menuId);
}
