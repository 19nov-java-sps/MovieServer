package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
}
