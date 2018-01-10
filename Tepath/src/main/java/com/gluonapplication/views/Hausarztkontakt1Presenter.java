package com.gluonapplication.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.paint.Color;

public class Hausarztkontakt1Presenter  {
	
    public java.sql.Connection con;
    

	
    @FXML
    private View hausarztkontakt1;

    @FXML
    private Label labelNameHA;

    @FXML
    private Label labelStrasseHA;

    @FXML
    private Label labelTelefonHA;

    @FXML
    private Label labelMailHA;

    String PatientID = PrimaryPresenter.PatientID;

    public void initialize() {
    	
    	try {
    	
    	MyConn co = new MyConn();
		con=co.getconn();
		Statement st = con.createStatement();
    	String query3 ="SELECT dbo.Hausarzt.Name, dbo.Hausarzt.Adresse, "
		+ "dbo.Hausarzt.Telefon FROM dbo.Hausarzt INNER JOIN "
		+ "dbo.Patienten ON dbo.Hausarzt.ID_Hausarzt = "
		+ "dbo.Patienten.Hausarzt"
		+ " Where (dbo.Patienten.ID_Patient =" + PatientID +")" ;

    	
		ResultSet rs = st.executeQuery(query3);
		
		String _Name="";
		String _Strasse="";
		String _Telefon="";
		while (rs.next()){
			_Name=rs.getString("Name");
			_Strasse=rs.getString("Adresse");
			_Telefon=rs.getString("Telefon");
			
			labelNameHA.setText(_Name);
			labelStrasseHA.setText(_Strasse);
			labelTelefonHA.setText(_Telefon);
			}
    	}

		catch(Exception exc){
			exc.printStackTrace();
		}

    	
    	hausarztkontakt1.setShowTransitionFactory(BounceInRightTransition::new);
    	hausarztkontakt1.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Hausarzt");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
