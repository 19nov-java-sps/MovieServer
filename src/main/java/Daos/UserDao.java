package Daos;

import java.sql.SQLException;
import java.util.List;


import Models.Users;



public interface UserDao {
	
	public List<Users> getUsers();
	public boolean createAccount(Users u);
	public int deleteUserById(int userId);
	public Users getUserById(int userId);
	boolean updateUser(int userid, String email, String password);
	public Users Login(String email, String password) throws SQLException;
	
	
	
	
}
