package com.gluonapplication.views;


import com.gluonhq.charm.glisten.mvc.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.sql.*;


import javafx.fxml.FXML;

public class GesundheitszustandPresenter {
	
	public java.sql.Connection con;
		
	  @FXML
	    private View Gesundheitszustand;

	    @FXML
	    private ComboBox<?> Terminauswahl;

	    @FXML
	    private TextField Temperaturlabel;

	    @FXML
	    private TextField Zuckerwertlabel;

	    @FXML
	    private Button GZTEMPZUCKERbutton;

	    @FXML
	    private RadioButton schuettelfrostyes;

	    @FXML
	    private ToggleGroup Schuettelfrost;

	    @FXML
	    private RadioButton schuettelfrostno;

	    @FXML
	    private RadioButton starkesfieberyes;

	    @FXML
	    private ToggleGroup starkesFieber;

	    @FXML
	    private RadioButton starkesfieberno;

	    @FXML
	    private RadioButton infektionenyes;

	    @FXML
	    private ToggleGroup Infektionen;

	    @FXML
	    private RadioButton infektionenno;

	    @FXML
	    private RadioButton durchfallyes;

	    @FXML
	    private ToggleGroup Durchfall;

	    @FXML
	    private RadioButton durchfallno;

	    @FXML
	    private Button GZFragebogenbutton;

	    @FXML
	    void saveGZFragebogen(ActionEvent event) {

	    }

	    @FXML
	    void saveTempZucker(ActionEvent event) {

	    }

	
	
	
	public void initialize() {
		Gesundheitszustand.setShowTransitionFactory(BounceInRightTransition::new);
   	 Gesundheitszustand.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Gesundheitszustand");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });

}
}
