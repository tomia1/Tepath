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

public class HausarztkontaktPresenter  {
	

    @FXML
    private View hausarzt;
//    @FXML
//    private Button Zurück;
//
//    @FXML
//    void ButtonSendenClick(ActionEvent event) {
//
//    }
//
//    @FXML
//    void ButtonZurückKlick(ActionEvent event) {
//    	Zurück.setOnAction(e -> 
//        MobileApplication.getInstance().switchView(GluonApplication.KONTAKTE_VIEW));
      	
   // }


//    protected void updateAppBar(AppBar appBar) {
//        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> switchView(SECONDARY_VIEW)));
//        appBar.setTitleText("Hausarzt");
//    }
    public void initialize() {
    	hausarzt.setShowTransitionFactory(BounceInRightTransition::new);
    	hausarzt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Hausarzt");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }
}
