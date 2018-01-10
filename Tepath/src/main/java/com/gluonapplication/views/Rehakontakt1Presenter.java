package com.gluonapplication.views;

import java.sql.ResultSet;
import java.sql.Statement;

import com.gluonapplication.GluonApplication;
import com.gluonapplication.MyConn;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Rehakontakt1Presenter  {
	
    public java.sql.Connection con;
    
    public String PatientID;
	

    @FXML
    private View rehakontakt;

    @FXML
    private Label labelNameR;

    @FXML
    private Label labelStrasseR;

    @FXML
    private Label labelTelefonR;

    @FXML
    private Label labelMail;
  

    public void initialize() {
    	
    	try {
        	
    	MyConn co = new MyConn();
		con=co.getconn();
		Statement st = con.createStatement();
    	String query3 ="SELECT dbo.Reha.Name, dbo.Reha.Adresse, "
		+ "dbo.Reha.Telefon FROM dbo.Reha INNER JOIN "
		+ "dbo.Patienten ON dbo.Reha.ID_Reha = "
		+ "dbo.Patienten.Reha "
		+ " Where (dbo.Patienten.ID_Patient = 1 ) " ;

    	
		ResultSet rs = st.executeQuery(query3);
		
		String _Name="";
		String _Strasse="";
		String _Telefon="";
		while (rs.next()){
			_Name=rs.getString("Name");
			_Strasse=rs.getString("Adresse");
			_Telefon=rs.getString("Telefon");
			
			labelNameR.setText(_Name);
			labelStrasseR.setText(_Strasse);
			labelTelefonR.setText(_Telefon);
			}
    	}

		catch(Exception exc){
			exc.printStackTrace();
		}
    	
    	rehakontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	rehakontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Reha");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
