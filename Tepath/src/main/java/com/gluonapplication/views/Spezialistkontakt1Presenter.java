package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Spezialistkontakt1Presenter  {
	

    @FXML
    private View spezialistkontakt;
    
    @FXML
    private Label labelN;

    @FXML
    private Label labelName;

    @FXML
    private Label labelA;

    @FXML
    private Label labelStrasse;

    @FXML
    private Label labelOrt;

    @FXML
    private Label LabelT;

    @FXML
    private Label labelTelefon;

    @FXML
    private Label labelE;

    @FXML
    private Label labelMail;

//    protected void updateAppBar(AppBar appBar) {
//        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> switchView(SECONDARY_VIEW)));
//        appBar.setTitleText("Vor Rehaeintritt");
//    }
    public void initialize() {
    	spezialistkontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	spezialistkontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Spezialist");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
