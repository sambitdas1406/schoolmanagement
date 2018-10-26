package org.student.App;

import java.sql.*;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root & password=sambit");
	}catch(Exception e){System.out.println(e);}
	return con;
    }
}
