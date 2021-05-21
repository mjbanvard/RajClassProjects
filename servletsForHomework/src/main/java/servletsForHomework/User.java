package servletsForHomework;

import java.util.Date;

public class User {
	
	int id ;
	String firstName;
	String lastName;
	String username;
	String password;
	Date dob;
	
	User(){};
	
	User(int id, String firstName, String lastName, String username, String password, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dob = dob;
	}
	
}
