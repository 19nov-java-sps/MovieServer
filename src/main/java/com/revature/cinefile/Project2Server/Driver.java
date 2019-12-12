package com.revature.cinefile.Project2Server;

import Daos.UserDaoImpl;
import Models.Users;

public class Driver {
	public static void main(String args[]) {

UserDaoImpl bucci= new UserDaoImpl();

//System.out.print(bucci.getUsers());

//Users Justin = new Users("Robert","Bucci","Bucci490@hotmail.com","1234", true);

//System.out.print(bucci.createAccount(Justin));

 System.out.print(bucci.deleteUserById(1));
//System.out.print(bucci.getUserById(1));



}
}