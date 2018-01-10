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
//import com.gluonhq.charm.down.plugins.android;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Spitalkontakt1Presenter  {
	
	
    public java.sql.Connection con;
    
    String PatientID = PrimaryPresenter.PatientID;
    


    @FXML
    private View spitalkontakt;

    @FXML
    private Label labelNameSPI;

    @FXML
    private Label labelStrasseSPI;

    @FXML
    private Label labelTelefonSPI;

    @FXML
    private Label labelMail;
    
    
    
    public void initialize() {
    	
    	try {
        	
    	MyConn co = new MyConn();
		con=co.getconn();
		Statement st = con.createStatement();
    	String query3 ="SELECT dbo.Spital.Name, dbo.Spital.Adresse, "
		+ "dbo.Spital.Telefon FROM dbo.Spital INNER JOIN "
		+ "dbo.Patienten ON dbo.Spital.ID_Spital = "
		+ "dbo.Patienten.Spital"
		+ " Where (dbo.Patienten.ID_Patient =" + PatientID +")" ;

    	
		ResultSet rs = st.executeQuery(query3);
		
		String _Name="";
		String _Strasse="";
		String _Telefon="";
		while (rs.next()){
			_Name=rs.getString("Name");
			_Strasse=rs.getString("Adresse");
			_Telefon=rs.getString("Telefon");
			
			labelNameSPI.setText(_Name);
			labelStrasseSPI.setText(_Strasse);
			labelTelefonSPI.setText(_Telefon);
			}
    	}

		catch(Exception exc){
			exc.printStackTrace();
		}
    	
    	
    	spitalkontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	spitalkontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Spital");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
                
            }
        });
    }
}
