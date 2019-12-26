package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favorites {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int favoriteId;
	
	
	
	@Column(name="movieid")
	private int movieId;
	
	
	
	
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="movietitle")
	private String movieTitle;
	
	
	
	
	
	
	
	
	
	public Favorites() {
		super();
	}
	
	
	public Favorites(int movieId, int userId, String movieTitle) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.movieTitle = movieTitle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + favoriteId;
		result = prime * result + movieId;
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (favoriteId != other.favoriteId)
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public Favorites(int favoriteId, int movieId, int userId, String movieTitle) {
		super();
		this.favoriteId = favoriteId;
		this.movieId = movieId;
		this.userId = userId;
		this.movieTitle = movieTitle;
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
}
