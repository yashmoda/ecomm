package com.cf.favorites;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoritesRowMapper implements RowMapper {

    @Override
    public Favorites mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
        Favorites favorites = new Favorites();
        favorites.setId(resultSet.getInt("id"));
        favorites.setPhone(resultSet.getString("phone"));
        favorites.setProduct_id(resultSet.getInt("product_id"));
        return favorites;
    }
}
