package com.gluonapplication.views;

import java.sql.DriverManager;

import java.sql.*;
import java.util.*;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrimaryPresenter {

    public static final String URL = "jdbc:sqlserver://147.87.116.42:1433; databaseName=Tepath";
    public static Connection connection;
    public String loginvalue = "" ;
    public String passwordvalue = "";
	
	
    @FXML
    private View primary;

    @FXML
    private Button anmelden;
    
    @FXML
    private TextField userName;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label message;

    @FXML
    void MakeLogin(ActionEvent event) {
    	
    	this.loginvalue = userName.getText();
    	this.passwordvalue = password.getText();
    	
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		
<<<<<<< HEAD
    		java.sql.Connection connection = DriverManager.getConnection(URL,"Patient", "change9It");
    		java.sql.Statement myStmt = connection.createStatement();
    		
    		ResultSet myRs = myStmt.executeQuery("select * from login");
    		
    		
        	if (userName.getText().equals(myRs.getString("Username")) && password.getText().equals(myRs.getString("Password"))) {
        	anmelden.setOnAction(e -> 
            MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
        	} else {
        		message.setText("Benutzername oder Passwort falsch!");
        		message.setTextFill(Color.RED);
        	}
    		
    		
=======
    		java.sql.Connection connection = DriverManager.getConnection(URL,loginvalue, passwordvalue);
>>>>>>> branch 'master' of https://github.com/tomia1/Tepath.git
    	}
    	
    	catch(Exception exc){
    		exc.printStackTrace();
    	}
    	
    	
//    	if (userName.getText().equals("hager") && password.getText().equals("hager")) {
//    	anmelden.setOnAction(e -> 
//        MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
//    	} else {
//    		message.setText("Benutzername oder Passwort falsch!");
//    		message.setTextFill(Color.RED);
//    	}
    }


    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setTitleText("Login");
            }
        });
    }
    
    private static String request(){
    	String url = "jdbc:mysql://147.87.116.42/SQLEXPRESS";
    	String user = "myUserName";
    	String passwd = "fencyPassword";
    	String result = "none";
    	try{ // Loading the MySQL Connector/J driver
    	Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    	result = "Error while loading the Driver: " + e.getMessage();
    	System.out.println("Error while loading the Driver: " + e.getMessage());
    	return result;
    	}
    	Connection conn = null;
    	try{
    	/* Initializing the connection */
    	conn = (Connection) DriverManager.getConnection(url, user, passwd);
    	Statement statement = (Statement) conn.createStatement();
    	ResultSet resultset = statement.executeQuery("select * from tablename limit 10, 10;");
    	result = "";
    	while(resultset.next()){
    	result = String.format("%s ... %d", result, resultset.getInt("columNameInTable"));
    	}
    	}catch(SQLException e){
    	result = "SQL connection error: " + e.getMessage();
    	System.out.println("SQL connection error: " + e.getMessage());
    	}finally {
    	if(conn != null){
    	try{
    	/* CLosing connection */
    	conn.close();
    	}catch (SQLException e){
    	result = "Error while closing the connection: " + e.getMessage();
    	System.out.println("Error while closing the connection: " + e.getMessage());
    	}
    	}
    	}
    	return result;
    	}

}
