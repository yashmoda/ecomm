package com.cf.favorites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/com/cf/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping(path = "/add")
    public ResponseEntity addFavorites(@RequestBody Favorites favorites)
    {
        favoritesService.addFavorites(favorites);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Favorites>> showFavorites(@RequestParam String phone)
    {
        List<Favorites> favorites = favoritesService.showFavorites(phone);
        return new ResponseEntity<List<Favorites>>(favorites, HttpStatus.OK);
    }

    @DeleteMapping(path="/delete")
    public ResponseEntity deleteFavorite(@RequestBody Favorites favorites)
    {
        favoritesService.deleteFavorites(favorites);
        return new ResponseEntity(HttpStatus.OK);
    }
}
