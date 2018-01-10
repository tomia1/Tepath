package com.gluonapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonapplication.GluonApplication;
import javafx.fxml.FXML;

public class SecondaryPresenter {
	
	String PatientID;

    @FXML
    private View ablauf;

    public void initialize() {
        ablauf.setShowTransitionFactory(BounceInRightTransition::new);
        
//        ablauf.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text, 
//            e -> System.out.println("Info")).getLayer());
        
        ablauf.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                 MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Ablauf");
                
            }
        });
    }
}
