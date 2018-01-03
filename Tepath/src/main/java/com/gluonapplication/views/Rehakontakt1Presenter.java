package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import android.R;
import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.view.*;

public class Rehakontakt1Presenter  {
	
	ImageView image;
    @FXML
    private View rehakontakt;
    
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
    private Label labelT;

    @FXML
    private Label labelTelefon;
//@FXML
//private 
//    @FXML
//    private Label labelE;

    @FXML
    private Label labelMail;
    @FXML
    private Label RH_AnrufLabel;
  @FXML
  private Button RH_Anrufen;
  @FXML
  private Button RH_Map;
  @FXML
  private HBox RH_MapImage;
  
//  @FXML
//  private image=
//  image = (ImageView) findViewById(R.id.mapImage)
 
   public void CallReha(){
	   
	  if(RH_Anrufen.isPressed()){
		  Intent callIntent = new Intent(Intent.ACTION_DIAL);
		 callIntent.setData(Uri.parse("tel:032 328 29 95"));
		  callIntent.setData(Uri.parse("tel:032 328 29 95"));
		  startActivity(callIntent);
		  
		  RH_AnrufLabel.setText(labelTelefon +  ": Calling...");
	  	  RH_AnrufLabel.setTextFill(Color.GREEN);
		 

 
	  }
  
   }
   public void ShowMap(){
	   
		  if(RH_Map.isPressed()){
		// RH_MapImage.setImageResource(R.drawable.RehaImage.png);
	    	} 
			  
	 
		  }
	  
	   
  

private void startActivity(Intent callIntent) {
	// TODO Auto-generated method stub
	
}
	//    protected void updateAppBar(AppBar appBar) {
//        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> switchView(SECONDARY_VIEW)));
//        appBar.setTitleText("Vor Rehaeintritt");
//    @FXML
//    void mybuttonClick(ActionEvent event) {
//    	rahakontakt.setOnAction(e -> 
//        MobileApplication.getInstance().switchView(GluonApplication.KONTAKTE_VIEW));
//    }
//    }
    public void initialize() {
    	rehakontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	rehakontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {	
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Reha");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
