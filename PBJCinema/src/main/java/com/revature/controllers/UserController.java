package com.revature.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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

import com.revature.exceptions.TrackNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
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
	
	@PostMapping("/users")
	@ResponseBody
	public void addUser(@RequestParam("firstname")String firstname, @RequestParam("lastname")String lastname, @RequestParam("emailaddress")String emailaddress, @RequestParam("password") String password) {
		Users newUser= new Users(firstname, lastname, emailaddress,password);
		service.createAccount(newUser);
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public void addUser(@RequestParam("emailaddress")String emailaddress, @RequestParam("password")String password) throws SQLException {
	
		Users u=service.Login(emailaddress,password);
		
		

		if(u!=null) {
			String token =u.getUserId()+":"+u.isAdmin();
	
		
			@GetMapping("/response-entity")
			public Mono<ResponseEntity<String>> usingResponseEntityBuilder() {
			    String responseHeaderKey = "Authorization";
			    String responseHeaderValue = token;
			    String responseBody = "Response with header using ResponseEntity (builder)";
			 
			    return Mono.just(ResponseEntity.ok()
			      .header(responseHeaderKey, responseHeaderValue)
			      .body(responseBody));
			}
		
		
		
	}
	
	
	
	
	
	
}
