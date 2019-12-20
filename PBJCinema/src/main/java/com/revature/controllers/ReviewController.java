package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/reviews")
	@ResponseBody
	public List<Reviews> getReviews(){
		
		return service.getReviews();
	}
	


	 @RequestMapping(value = "/reviews", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	    public ResponseEntity<String> editReview(@RequestBody Reviews review) 
	    {
	 int id= review.getReviewId();
	 String postBody= review.getPostBody();
	 String postTitle= review.getPostTitle();
	
		 service.editReview(id,postTitle,postBody);
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
