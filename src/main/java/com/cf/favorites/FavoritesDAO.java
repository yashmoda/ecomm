package com.cf.favorites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class FavoritesDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addFavorites(Favorites favorites)
    {
        String query = "INSERT INTO favorites (product_id, phone) values (?, ?)";
        jdbcTemplate.update(query, favorites.getProduct_id(), favorites.getPhone());
    }

    public List<Favorites> showFavorites(String phone)
    {
        String query = "SELECT * FROM favorites WHERE phone = ?";
        RowMapper<Favorites> mapper = new FavoritesRowMapper();
        return jdbcTemplate.query(query, mapper, phone);
    }

    public void deleteFavorites(Favorites favorites)
    {
        String query = "DELETE FROM favorites WHERE id = ?";
        jdbcTemplate.update(query, favorites.getId());
    }
}
