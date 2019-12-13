package com.revature.cinefile.Project2Server;

import java.sql.SQLException;

import Daos.UserDaoImpl;
import Models.Users;

public class Driver {
	public static void main(String args[]) throws SQLException {

UserDaoImpl bucci= new UserDaoImpl();

//System.out.print(bucci.getUsers());

//Users Justin = new Users("Robert","Bucci","Bucci490@hotmail.com","1234", true);

//System.out.print(bucci.createAccount(Justin));


//System.out.print(bucci.getUserById(1));

System.out.print(bucci.Login("Bucci490@hotmail.com","1234"));

}
}