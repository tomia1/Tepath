package com.gluonapplication;

import java.sql.*;

/**
 * Die Klasse MyConn ist für die Verbindung mit der Datenbank zuständig. Da wir
 * eine Klasse für die Datenbankverbindung erstellt haben, muss die ganze
 * Information und die Verbindung zur Datenbank nicht bei jeder Datenbankabfrage
 * in jeder Klasse geschrieben werden. Für die Datenbankverbindung braucht es
 * das URL der Datenbank sowie das PAsswort und der Benutzername. Diese werden
 * alle hier festgelegt.
 * 
 * @author Hager
 *
 */
public class MyConn {

	String URL;
	String User;
	String Password;
	Connection con;

	public MyConn() {

		User = "Patient";
		Password = "change9It";
		URL = "jdbc:sqlserver://147.87.116.42:1433; databaseName=Tepath";
	}

	public Connection getconn() {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, User, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
