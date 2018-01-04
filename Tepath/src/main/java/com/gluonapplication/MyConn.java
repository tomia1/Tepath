package com.gluonapplication;
import java.sql.*;

public class MyConn {

    String URL ;
    String User;
    String Password;
    Connection con;
    
    public MyConn () {

        User="Patient";
        Password="change9It";
      	URL = "jdbc:sqlserver://147.87.116.42:1433; databaseName=Tepath";
      	}
    
   public Connection getconn() {
	   
	   try{
		   
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   } catch (ClassNotFoundException e) {
				   e.printStackTrace() ;
		   }
	   try {
		   con=DriverManager.getConnection(URL,User,Password);
		   	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return con;
   }
    
}
