package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.UserDaoImpl;
import com.revature.models.Users;

@Service
public class UserService {
	
	UserDaoImpl service= new UserDaoImpl();
	

	public List<Users> getUsers(){
		return service.getUsers();
	}
	public boolean createAccount(Users u) {
		return service.createAccount(u);
	}
	public int deleteUserById(int userId) {
		return service.deleteUserById(userId);
	}
	public Users getUserById(int userId) {
		return service.getUserById(userId);
	}
	public boolean updateUser(int userid, String email, String password, String firstName, String lastName) {
		return service.updateUser(userid, email, password, firstName, lastName);
	}
	public Users Login(String email, String password, boolean isBanned) throws SQLException{
		return service.Login(email, password, isBanned);
	}
	
	
	
	
	

}
