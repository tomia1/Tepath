package com.gluonapplication.views;

import java.sql.DriverManager;

import java.sql.*;
import java.util.*;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gluonapplication.GluonApplication;
import com.gluonapplication.MyConn;
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

    public java.sql.Connection con;
	
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
    	
    	MyConn co = new MyConn();
    	con=co.getconn();
    	String query ="Select * from login where Username=? and Password=?";
    	try {
    		PreparedStatement pst=con.prepareStatement(query);
    		pst.setString(1, userName.getText());
    		pst.setString(2, password.getText());
    		ResultSet rs=pst.executeQuery();
    		int i=0;
    		String _user="";
    		String _pass="";
    		while (rs.next()){
    			_user=rs.getString("Username");
    			_pass=rs.getString("Password");
    			}
    		if (_user.equals(userName.getText()) && _pass.equals(password.getText() ) ) {
	         	anmelden.setOnAction(e -> 
	             MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW)); 			
    		}
    		else {
         		message.setText("Benutzername oder Passwort falsch!");
         		message.setTextFill(Color.RED);
    		}
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    	
    	}
    	
    }
    
} ;
    	
//    	try {
//    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//    		
//    		java.sql.Connection connection = DriverManager.getConnection(URL,loginvalue, passwordvalue);
//    		
//    		    		java.sql.Statement myStmt = connection.createStatement();
//    		     		
//    		     		ResultSet myRs = myStmt.executeQuery("select * from login");
//    		     		
//    		     		
//    		         	if (userName.getText().equals(myRs.getString("Username")) && password.getText().equals(myRs.getString("Password"))) {
//    		         	anmelden.setOnAction(e -> 
//    		             MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
//    		         	} else {
//    		         		message.setText("Benutzername oder Passwort falsch!");
//    		         		message.setTextFill(Color.RED);
//    		         	}
//    		     		
//    		     		
//    		
//    	}
//    	
//    	catch(Exception exc){
//    		exc.printStackTrace();
//    	}
//    	
//    	        finally {  
//    		             if (connection != null) try { connection.close(); } catch(Exception e) {}  
//    		         }  
    	
//    	if (userName.getText().equals("hager") && password.getText().equals("hager")) {
//    	anmelden.setOnAction(e -> 
//        MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));
//    	} else {
//    		message.setText("Benutzername oder Passwort falsch!");
//    		message.setTextFill(Color.RED);
//    	}

