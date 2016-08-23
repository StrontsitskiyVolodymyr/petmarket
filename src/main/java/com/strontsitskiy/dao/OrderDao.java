package com.strontsitskiy.dao;

import com.strontsitskiy.models.Order;

import java.sql.SQLException;

public interface OrderDao {
    public void addOrder(Order order)throws SQLException;
    public void deleteOrder(Order order)throws SQLException;
    public Order getOrder(int id)throws SQLException;
}
