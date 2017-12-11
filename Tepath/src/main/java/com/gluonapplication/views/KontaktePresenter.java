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

	    }

	    @FXML
	    void buttonHausarztClick(ActionEvent event) {
	    	hausarzt.setOnAction(e -> 
	        MobileApplication.getInstance().switchView(GluonApplication.HAUSARZTKONTAKT_VIEW));
	    }

	    @FXML
	    void buttonRehaClick(ActionEvent event) {

	    }

	    @FXML
	    void buttonSpezialistClick(ActionEvent event) {

	    }

	    @FXML
	    void buttonSpitalClick(ActionEvent event) {

	    }

	    public void initialize() {
	    	kontakt.setShowTransitionFactory(BounceInRightTransition::new);
	    	kontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
	             if (newValue) {
	                 AppBar appBar = MobileApplication.getInstance().getAppBar();
	                 appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
	                         MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
	                 appBar.setTitleText("Kontakte");
	                 appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
	                         System.out.println("Search")));
	             }
	         });
	    }

}
