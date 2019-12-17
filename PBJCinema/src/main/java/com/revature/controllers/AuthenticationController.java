package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Employee;
import com.revature.models.Users;
import com.revature.services.UserService;



@CrossOrigin
@Controller
public class AuthenticationController {
	
	

	@Autowired
	private UserService service;
	
	//AuthenticationController ac= new AuthenticationController();
	@PostMapping("/login")
	@ResponseBody
public void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		
	this.authenticate(request, response);
	
	
	
	
}

	
	




	

	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String email = request.getParameter("emailaddress");
		String password = request.getParameter("password");

		Users u =service.Login(email,password);
	
		if(u!=null) {
			String token = u.getUserId()+":"+u.isAdmin();
	
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
		
	}
}
