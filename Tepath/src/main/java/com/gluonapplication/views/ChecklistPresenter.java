package com.gluonapplication.views;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChecklistPresenter {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private View viewChecklist;

    @FXML
    private Button vorSpezialist;

    @FXML
    private Button vorSpital;

    @FXML
    private Button vorReha;

    @FXML
    void buttonRehaClick(ActionEvent event) {

    }

    @FXML
    void buttonSpezialistClick(ActionEvent event) {

    }

    @FXML
    void buttonSpitalClick(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        viewChecklist.setShowTransitionFactory(BounceInRightTransition::new);
        
        
        viewChecklist.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Checklisten");
            }
        });
    }
}
