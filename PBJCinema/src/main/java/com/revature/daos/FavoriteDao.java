package com.revature.daos;

import com.revature.models.Favorites;

import java.util.List;
public interface FavoriteDao {
	
	public List<Favorites>getAllFavorites();
	public List<Favorites> FavoritesById(int userId);
	public boolean deleteFavoriteByName(String name);
	public boolean addFavorite(Favorites fav);
	
}