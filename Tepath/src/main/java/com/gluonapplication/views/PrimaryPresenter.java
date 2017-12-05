package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryPresenter {

    @FXML
    private View primary;

    @FXML
    private Button ablaufBtn;

    @FXML
    private Button checklistbtn;

    @FXML
    private Button kontakteBtn;

    @FXML
    private Button gesBtn;

    @FXML
    void onClickAblauf(ActionEvent event) {
    	ablaufBtn.onActionProperty();
    }

    @FXML
    void onClickChecklist(ActionEvent event) {

    }

    @FXML
    void onClickGes(ActionEvent event) {

    }

    @FXML
    void onClickKontakte(ActionEvent event) {

    }


    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Startseite");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }

////<<<<<<< HEAD
//    @FXML
//    void buttonClick() {
//        label.setText("Hello JavaFX Universe!");
//    }
//    @FXML
//    void myBtnClick() {
//        label.setText("keep on!");
//    }
//
//=======
////>>>>>>> branch 'master' of https://github.com/tomia1/Tepath2.git
}
