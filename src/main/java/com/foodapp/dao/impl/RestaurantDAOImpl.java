package com.foodapp.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.model.Restaurant;
import com.foodapp.DBUtil.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    // ➕ Add Restaurant
    @Override
    public int addRestaurant(Restaurant r) {

        int result = 0;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO restaurants (name, cuisine_type, address, phone_number, rating, image_url, is_active) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, r.getName());
            ps.setString(2, r.getCuisineType());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getPhoneNumber());
            ps.setDouble(5, r.getRating());
            ps.setString(6, r.getImageUrl());
            ps.setBoolean(7, r.isActive());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // 🔍 Get Restaurant By ID
    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant r = null;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Restaurant();

                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCuisineType(rs.getString("cuisine_type"));
                r.setAddress(rs.getString("address"));
                r.setPhoneNumber(rs.getString("phone_number"));
                r.setRating(rs.getDouble("rating"));
                r.setImageUrl(rs.getString("image_url"));
                r.setActive(rs.getBoolean("is_active"));
                r.setCreatedDate(rs.getTimestamp("created_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }

    // 📋 Get All Restaurants
    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM restaurants";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Restaurant r = new Restaurant();

                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCuisineType(rs.getString("cuisine_type"));
                r.setAddress(rs.getString("address"));
                r.setPhoneNumber(rs.getString("phone_number"));
                r.setRating(rs.getDouble("rating"));
                r.setImageUrl(rs.getString("image_url"));
                r.setActive(rs.getBoolean("is_active"));
                r.setCreatedDate(rs.getTimestamp("created_date"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✏️ Update Restaurant
    @Override
    public int updateRestaurant(Restaurant r) {

        int result = 0;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE restaurants SET name=?, cuisine_type=?, address=?, phone_number=?, rating=?, image_url=?, is_active=? WHERE restaurant_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, r.getName());
            ps.setString(2, r.getCuisineType());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getPhoneNumber());
            ps.setDouble(5, r.getRating());
            ps.setString(6, r.getImageUrl());
            ps.setBoolean(7, r.isActive());
            ps.setInt(8, r.getRestaurantId());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ❌ Delete Restaurant
    @Override
    public int deleteRestaurant(int restaurantId) {

        int result = 0;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM restaurants WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, restaurantId);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}