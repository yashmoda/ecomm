package com.cf.favorites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {

    @Autowired
    private FavoritesDAO favoritesDAO;

    public void addFavorites(Favorites favorites)
    {
        favoritesDAO.addFavorites(favorites);
    }

    public void deleteFavorites(Favorites favorites)
    {
        favoritesDAO.deleteFavorites(favorites);
    }

    public List<Favorites> showFavorites(String phone)
    {
        List<Favorites> favorites = favoritesDAO.showFavorites(phone);
        return favorites;
    }
}
