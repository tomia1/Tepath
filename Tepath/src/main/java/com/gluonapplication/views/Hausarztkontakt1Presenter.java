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

public class Hausarztkontakt1Presenter  {
	

    @FXML
    private View hausarztkontakt1;
    
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

    @FXML
    private Label labelE;

    @FXML
    private Label labelMail;
//--------------------------------------------------------------
    @FXML
    private Label HA_AnrufLabel;
  @FXML
  private Button HA_Anrufen;
  @FXML
  private Button HA_Map;
  @FXML
  private ImageView  HA_MapImage;
  

  
   public void CallHausarzt(){
	   
	  if(HA_Anrufen.isPressed()){
		  Intent callIntent_HA = new Intent(Intent.ACTION_DIAL);
		 callIntent_HA.setData(Uri.parse("tel:031 111 11 11"));
		  callIntent_HA.setData(Uri.parse("tel:031 111 11 11"));
		  startActivity(callIntent_HA);
		  
		  HA_AnrufLabel.setText(labelTelefon +  ": Calling...");
	  	  HA_AnrufLabel.setTextFill(Color.GREEN);
		 

		  
 
	}
  
   }  
   public void ShowMap(){
	   
	    if(HA_Map.isPressed()){
		 HA_MapImage.setImageResource(R.drawable.HA_MapImage.png);
	    	} 
			  
	 
		  }
    
    //----------------------------------------------------------
   private void startActivity(Intent callIntent) {
		// TODO Auto-generated method stub
		
	}

    public void initialize() {
    	hausarztkontakt1.setShowTransitionFactory(BounceInRightTransition::new);
    	hausarztkontakt1.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                
                appBar.setTitleText("Hausarzt");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
