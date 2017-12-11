package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;

public class SpitalkontaktPresenter  {
	

    @FXML
    private View spitalkontakt;

//    protected void updateAppBar(AppBar appBar) {
//        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> switchView(SECONDARY_VIEW)));
//        appBar.setTitleText("Vor Rehaeintritt");
//    }
    public void initialize() {
    	spitalkontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	spitalkontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Spitalkontakt");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }
}
