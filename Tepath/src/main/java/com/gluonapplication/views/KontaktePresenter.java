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
	    void buttonApothekeClick(ActionEvent event) {
	    	apotheke.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.APOTHEKEKONTAKT_VIEW));
	    }

	    @FXML
	    void buttonHausarztClick(ActionEvent event) {
	    	hausarzt.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.HAUSARZTKONTAKT_VIEW));
	    }

	    @FXML
	    void buttonRehaClick(ActionEvent event) {
	    	reha.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.REHAKONTAKT_VIEW));
	    }

	    @FXML
	    void buttonSpezialistClick(ActionEvent event) {
	    	spezialist.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.SPEZIALISTKONTAKT_VIEW));
	    }

	    @FXML
	    void buttonSpitalClick(ActionEvent event) {
	    	spital.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.SPITALKONTAKT_VIEW));
	    }

	    public void initialize() {
	    	kontakt.setShowTransitionFactory(BounceInRightTransition::new);
	    	kontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
	             if (newValue) {
	                 AppBar appBar = MobileApplication.getInstance().getAppBar();
	                 appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
	                         MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
	                 appBar.setTitleText("Kontakte");
	                 appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
	                         MobileApplication.getInstance().switchToPreviousView()));
	             }
	         });
	    }

}
