package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class KontaktePresenter {
	
	String PatientID;
	
	    @FXML
	    private View kontakt;

	    @FXML
	    private Button hausarzt;

	    @FXML
	    private Button spital;

	    @FXML
	    private Button apotheke;

	    @FXML
	    private Button reha;

	    @FXML
	    private Button spezialist;

	    @FXML
	    void buttonApothekekontaktClick(ActionEvent event) {
	    	apotheke.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.APOTHEKEKONTAKT1_VIEW));
	    }

	    @FXML
	    void buttonHausarztkontaktClick(ActionEvent event) {
	    	hausarzt.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.HAUSARZTKONTAKT1_VIEW));
	    }

	    @FXML
	    void buttonRehakontaktClick(ActionEvent event) {
	    	reha.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.REHAKONTAKT1_VIEW));
	    }

	    @FXML
	    void buttonSpezialistkontaktClick(ActionEvent event) {
	    	spezialist.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.SPEZIALISTKONTAKT1_VIEW));
	    }

	    @FXML
	    void buttonSpitalkontaktClick(ActionEvent event) {
	    	spital.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.SPITALKONTAKT1_VIEW));
	    }

	    public void initialize() {
	    	kontakt.setShowTransitionFactory(BounceInRightTransition::new);
	    	kontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
	             if (newValue) {
	                 AppBar appBar = MobileApplication.getInstance().getAppBar();
	                 appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
	                         MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
	                 appBar.setTitleText("Kontakte");
	             }
	         });
	    }

}
