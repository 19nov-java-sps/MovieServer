package com.revature.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Users;
import com.revature.services.UserService;

@RestController

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
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

	
	
	 @RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	    public ResponseEntity<String> createEmployee(@RequestBody Users user) 
	    {
	  
	
		 
		 
		 
	        service.createAccount(user);
	        return new ResponseEntity<String>(HttpStatus.CREATED);
	    }
	

		@PostMapping("/users/{id}")
		@ResponseBody
		public void  DeleteUserById(@PathVariable("id")int id) {
			service.deleteUserById(id);
			
		
		}
	
	
	

		 @RequestMapping(value = "/users/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		    public void updateUser(@RequestBody Users user, @PathVariable("id")int id) {
			 
service.updateUser(id,user.getEmailAddress(), user.getPassword(), user.getFirstName(), user.getLastName());
	

HttpHeaders responseHeaders = new HttpHeaders();

    responseHeaders.setAccessControlAllowOrigin("localhost:4200");
	
}


}
