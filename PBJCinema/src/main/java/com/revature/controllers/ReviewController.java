package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.models.Reviews;
import com.revature.services.ReviewService;


@Controller
@CrossOrigin(origins="localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/reviews")
	@ResponseBody
	public List<Reviews> getReviews(){
		
		return service.getReviews();
	}
	


	 @RequestMapping(value = "/reviews/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	    public ResponseEntity<String> editReview(@PathVariable("id")int id,@RequestBody Reviews review) 
	    {
	
	 String postBody= review.getPostBody();
	 String postTitle= review.getPostTitle();
	 String movieTitle=review.getMovieTitle();
	
		 service.editReview(id,postTitle,postBody, movieTitle);
		 HttpHeaders responseHeaders = new HttpHeaders();
		 responseHeaders.set("Access-Control-Allow-Origin","*");
	        return new ResponseEntity<String>(HttpStatus.CREATED);
	    }
	
	
		@RequestMapping(method=RequestMethod.GET, value="/reviews/{id}")
	@ResponseBody
	public Reviews getReviewsById(@PathVariable("id")int id) {
		Reviews u =service.getReviewsById(id);
		if(u == null) {
			throw new ReviewNotFoundException();
		}
		return u;
	}
		@RequestMapping(method=RequestMethod.DELETE, value="/reviews/{id}")
	@ResponseBody
	public boolean deleteReviewById(@PathVariable("id")int id) {
			service.deleteReviewById(id);
			
	return true;
	}
	
		
		
	 
		
		@RequestMapping(method=RequestMethod.GET, value="users/{userId}/reviews")
	@ResponseBody
	public List<Reviews> getReviewByUserId(@PathVariable("userId")int id) {
		List<Reviews> u =service.getUserReview(id);
		if(u == null) {
			throw new ReviewNotFoundException();
		}
		return u;
	}
		
		
	
	
	
	
}
