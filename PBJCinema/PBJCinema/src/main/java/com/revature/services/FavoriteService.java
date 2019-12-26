package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.FavoriteDaoImpl;
import com.revature.models.Favorites;



@Service
public class FavoriteService {

	FavoriteDaoImpl service= new FavoriteDaoImpl();
	
	public List<Favorites>getAllFavorites(){
		return service.getAllFavorites();
		
		
	}
	public List<Favorites> FavoritesById(int userId){
		return service.FavoritesById(userId);
	}
	public boolean deleteFavoriteByName(String name) {
		return service.deleteFavoriteByName(name);
	}
	public boolean addFavorite(Favorites fav) {
		return service.addFavorite(fav);
	}
	
	
	
}
