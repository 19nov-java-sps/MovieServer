package com.revature.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.TrackNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Track;
import com.revature.models.Users;
import com.revature.services.TrackService;
import com.revature.services.UserService;

@Controller
@CrossOrigin
public class UserController {

	
	@Autowired
	private UserService service;
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	@ResponseBody
	public List<Users> getUsers(@RequestParam(name="artist",required=false)String artist){
		
		return service.getUsers();

		
	}
	@GetMapping("/users/{id}")
	@ResponseBody
	public Users getUserById(@PathVariable("id")int id) {
		Users u=service.getUserById(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	
	
	
	
	
	
	
}
