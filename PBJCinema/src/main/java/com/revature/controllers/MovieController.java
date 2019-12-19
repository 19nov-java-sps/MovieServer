package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Movies;

import com.revature.services.MovieService;


@Controller
@CrossOrigin
public class MovieController {

	
	@Autowired
	private MovieService service;
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/movies")
	@ResponseBody
	public List<Movies> getMovies(){
		
		return service.getMovies();

		
	}
	
	
	
	
	
	
}
