package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;

public class MenuDAOImpl implements MenuDAO {

    // Add Menu
    @Override
    public int addMenu(Menu menu) {

        int result = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO menu (restaurant_id, item_name, description, price, category, is_available, image_url) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getCategory());
            ps.setBoolean(6, menu.isAvailable());
            ps.setString(7, menu.getImageUrl());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Get Menu By Id
    @Override
    public Menu getMenuById(int menuId) {

        Menu menu = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM menu WHERE menu_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, menuId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setCategory(rs.getString("category"));
                menu.setAvailable(rs.getBoolean("is_available"));
                menu.setImageUrl(rs.getString("image_url"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    // Get All Menu Items By Restaurant
    @Override
    public List<Menu> getAllMenusByRestaurant(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM menu WHERE restaurant_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setCategory(rs.getString("category"));
                menu.setAvailable(rs.getBoolean("is_available"));
                menu.setImageUrl(rs.getString("image_url"));

                menuList.add(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    // Update Menu
    @Override
    public int updateMenu(Menu menu) {

        int result = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE menu SET item_name=?, description=?, price=?, category=?, is_available=?, image_url=? WHERE menu_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, menu.getItemName());
            ps.setString(2, menu.getDescription());
            ps.setDouble(3, menu.getPrice());
            ps.setString(4, menu.getCategory());
            ps.setBoolean(5, menu.isAvailable());
            ps.setString(6, menu.getImageUrl());
            ps.setInt(7, menu.getMenuId());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Delete Menu
    @Override
    public int deleteMenu(int menuId) {

        int result = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM menu WHERE menu_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, menuId);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}