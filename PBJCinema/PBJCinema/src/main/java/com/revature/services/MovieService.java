package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.MovieDaoImpl;
import com.revature.models.Movies;


@Service
public class MovieService {
	MovieDaoImpl service= new MovieDaoImpl();
	
	
	public List<Movies> getMovies(){
		return service.getMovies();
	}
	public boolean addMovie(Movies u) {
		return service.addMovie(u);
	}
	public boolean deleteMovie(int movieId) {
		return service.deleteMovie(movieId);
	}
	public Movies getMovieById(int movieId) {
		return service.getMovieById(movieId);
	}

	
}
