package com.revature.daos;

import java.util.List;

import com.revature.models.Movies;


public interface MovieDao {
	
	
	public List<Movies> getMovies();
	public boolean addMovie(Movies u);
	public boolean deleteMovie(int movieId);
	public Movies getMovieById(int movieId);

	
	
	
	
	
	

}
