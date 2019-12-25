package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.models.Favorites;

import com.revature.services.FavoriteService;

@CrossOrigin
@Controller
public class FavoriteController {
	
	@Autowired
	FavoriteService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/favorites")
	@ResponseBody
	public List<Favorites> getFavorites(){
		
		return service.getAllFavorites();

		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/favorites/{id}")
@ResponseBody
public List<Favorites> getFavoritesByUserId(@PathVariable("id")int id) {
		
			
			return service.FavoritesById(id);

			
		}
		
	
	
}
	
	


