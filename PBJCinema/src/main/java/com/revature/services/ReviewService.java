package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.ReviewDaoImpl;
import com.revature.models.Reviews;

@Service
public class ReviewService {

	ReviewDaoImpl service= new ReviewDaoImpl();
	
	
	public List<Reviews> getReviews(){
		return service.getReviews();
	}
	public boolean createReview(Reviews re) {
		return service.createReview(re);
	}
	public boolean deleteReviewById(int reId) {
		return service.deleteReviewById(reId);
	}
	
	public boolean editReview(int reId, String postTitle, String postBody, String movieTitle) {
		
		return service.editReview(reId, postTitle, postBody, movieTitle);
		
	}
	public List<Reviews> getUserReview(int id) {
		
	return service.getReviewsByUserId(id);
	}
	public void editReview(Reviews review) {
	
		
		
		
	}
	public Reviews getReviewsById(int id) {
		return service.getReviewsById(id);
	}

		
}
