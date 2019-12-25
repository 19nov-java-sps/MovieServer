package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reviews {
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
private int reviewId;

	
	
@Column(name="movieid")
private int movieId;

private int userId;


private String postTitle;

private String postBody;

private String movieTitle;
public Reviews() {
	
}


@Override
public String toString() {
	return "Reviews [reviewId=" + reviewId + ", movieId=" + movieId + ", userId=" + userId + ", postTitle=" + postTitle
			+ ", postBody=" + postBody + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + movieId;
	result = prime * result + ((postBody == null) ? 0 : postBody.hashCode());
	result = prime * result + ((postTitle == null) ? 0 : postTitle.hashCode());
	result = prime * result + reviewId;
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
	Reviews other = (Reviews) obj;
	if (movieId != other.movieId)
		return false;
	if (postBody == null) {
		if (other.postBody != null)
			return false;
	} else if (!postBody.equals(other.postBody))
		return false;
	if (postTitle == null) {
		if (other.postTitle != null)
			return false;
	} else if (!postTitle.equals(other.postTitle))
		return false;
	if (reviewId != other.reviewId)
		return false;
	if (userId != other.userId)
		return false;
	return true;
}
public int getReviewId() {
	return reviewId;
}
public void setReviewId(int reviewId) {
	this.reviewId = reviewId;
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
public String getPostTitle() {
	return postTitle;
}
public void setPostTitle(String postTitle) {
	this.postTitle = postTitle;
}
public String getPostBody() {
	return postBody;
}
public void setPostBody(String postBody) {
	this.postBody = postBody;
}
public Reviews(int movieId, String postTitle, String postBody) {
	super();
	this.movieId = movieId;
	this.postTitle = postTitle;
	this.postBody = postBody;
}
public Reviews(int reviewId, int movieId, int userId, String postTitle, String postBody, String movieTitle) {
	super();
	this.reviewId = reviewId;
	this.movieId = movieId;
	this.userId = userId;
	this.postTitle = postTitle;
	this.postBody = postBody;
	this.movieTitle=movieTitle;
}


public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
}


public String getMovieTitle() {
	// TODO Auto-generated method stub
	return movieTitle;
}

}
