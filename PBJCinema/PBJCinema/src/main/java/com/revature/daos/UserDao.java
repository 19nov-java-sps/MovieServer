package com.revature.daos;

import java.sql.SQLException;
import java.util.List;




import com.revature.models.Users;
public interface UserDao {
	
	public List<Users> getUsers();
	public boolean createAccount(Users u);
	public int deleteUserById(int userId);
	public Users getUserById(int userId);
	//boolean updateUser(int userid, String email, String password);
	//public Users Login(String email, String password) throws SQLException;
	public boolean updateUser(int userid, String email, String password, String firstName, String lastName);
	public Users Login(String email, String password, boolean isBanned) throws SQLException;
	
	
	
	
}
