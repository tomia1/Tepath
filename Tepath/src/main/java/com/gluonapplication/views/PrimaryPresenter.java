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
    public static Connection connection = null;
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
    		
    		java.sql.Connection connection = DriverManager.getConnection(URL,loginvalue, passwordvalue);
    		
    		    		java.sql.Statement myStmt = connection.createStatement();
    		     		
    		     		ResultSet myRs = myStmt.executeQuery("select * from login");
    		     		
    		     		
    		         	if (userName.getText().equals(myRs.getString("Username")) && password.getText().equals(myRs.getString("Password"))) {
    		         	anmelden.setOnAction(e -> 
    		             MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
    		         	} else {
    		         		message.setText("Benutzername oder Passwort falsch!");
    		         		message.setTextFill(Color.RED);
    		         	}
    		     		
    		     		
    		
    	}
    	
    	catch(Exception exc){
    		exc.printStackTrace();
    	}
    	
    	        finally {  
    		             if (connection != null) try { connection.close(); } catch(Exception e) {}  
    		         }  
    	
//    	if (userName.getText().equals("hager") && password.getText().equals("hager")) {
//    	anmelden.setOnAction(e -> 
//        MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
//    	} else {
//    		message.setText("Benutzername oder Passwort falsch!");
//    		message.setTextFill(Color.RED);
//    	}
    }



   
}
