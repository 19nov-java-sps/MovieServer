package com.revature.controllers;


import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.models.Users;
import com.revature.services.UserService;



@CrossOrigin
@Controller
public class AuthenticationController {
	
	

	@Autowired
	private UserService service;
	

	@CrossOrigin(origins="http://localhost:4200")
	 @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpHeaders login(@RequestBody Users user) throws SQLException 
    {
  
		 HttpHeaders responseHeaders = new HttpHeaders();
		  
		 
		     
	 

		Users u =service.Login(user.getEmailAddress(),user.getPassword());
	
		if(u!=null) {
			String token = u.getUserId()+":"+u.isAdmin();
			  responseHeaders.set("Authorization",token);
			  
System.out.print(token);
			
		}
	
return responseHeaders;
	
	
    }




}
