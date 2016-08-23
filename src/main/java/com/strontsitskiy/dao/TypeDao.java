package com.strontsitskiy.dao;

import com.strontsitskiy.models.Type;


import java.sql.SQLException;

public interface TypeDao {
    public void addType(Type type)throws SQLException;
    public void deleteType(Type type)throws SQLException;
    public Type getType(String type)throws SQLException;
}
