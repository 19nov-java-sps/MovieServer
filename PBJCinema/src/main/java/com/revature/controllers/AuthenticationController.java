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




@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class AuthenticationController {
	
	

	@Autowired
	private UserService service;
	

	 @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpHeaders login(@RequestBody Users user) throws SQLException 
    {
  
		 HttpHeaders responseHeaders = new HttpHeaders();
		 
		     
	 

		Users u =service.Login(user.getEmailAddress(),user.getPassword(),user.isBanned());
	
		if(u!=null) {
			String token = u.getUserId()+":"+u.isAdmin();
			  responseHeaders.set("Authorization",token);
			  responseHeaders.set("Access-Control-Allow-Origin","*");
		;
			  
System.out.print(token);
			
		}
	
return responseHeaders;
	
	
    }




}
