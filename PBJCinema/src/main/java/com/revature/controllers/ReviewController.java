package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reviews;
import com.revature.models.Users;
import com.revature.services.MovieService;
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
	
	@GetMapping("/reviews/{id}")
	@ResponseBody
	public List<Reviews> getReviewByUserId(@PathVariable("id")int id) {
		List<Reviews> u =service.getUserReview(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	@PostMapping("/reviews/{id}")
	@ResponseBody
	public List<Reviews> getReviewByUserId(@PathVariable("id")int id) {
		List<Reviews> u =service.getUserReview(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	
	
	
	
}
