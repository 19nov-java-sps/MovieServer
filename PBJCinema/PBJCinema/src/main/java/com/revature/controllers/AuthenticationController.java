package com.revature.controllers;


import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.services.UserService;



@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/login")

public class AuthenticationController {
	
	

	@Autowired
	private UserService service;
	

@CrossOrigin
 @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void login(@RequestBody Users user,HttpServletResponse response) throws SQLException 
    {
  
	
		 
		     
	 

		Users u =service.Login(user.getEmailAddress(),user.getPassword(),user.isBanned());
	
		if(u!=null) {
			String token = u.getUserId()+":"+u.isAdmin();
			response.setStatus(200);
			response.setHeader("access-control-expose-headers", "Authorization");	// check if I need this
			response.setHeader("Authorization", token);
			
			  
		
			  

	
		}
	

	
	
    }




}
