package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reviews;


public interface ReviewDao {

	
	public List<Reviews> getReviews();
	public boolean createReview(Reviews re);
	public boolean deleteReviewById(int reId);
	public List<Reviews> getReviewsByUserId(int reId);
	boolean editReview(int userid, String postTitle, String postBody);
	Reviews getReviewsById(int reId);

		
	
	
	
	
	
	
}
