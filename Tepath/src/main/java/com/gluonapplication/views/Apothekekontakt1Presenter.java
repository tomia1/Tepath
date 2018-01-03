package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import android.content.Intent;
import android.net.Uri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Apothekekontakt1Presenter  {
	

	@FXML
    private View apothekekontakt;

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
    private Label APTK_AnrufLabel;
  @FXML
  private Button APTK_Anrufen;
  @FXML
  private Button APTK_Map;
  @FXML
  private HBox APTK_MapImage;
  
//  @FXML
//  private image=
//  image = (ImageView) findViewById(R.id.mapImage)
  void HAanrufen(){
	  if(APTK_Anrufen.isPressed()){
		 
		APTK_AnrufLabel.setText(labelTelefon +  ": Calling...");
  		APTK_AnrufLabel.setTextFill(Color.GREEN);

	    	} 
 
	  }
  
   public void CallApotheke(){
	   
	  if(APTK_Anrufen.isPressed()){
		  Intent callIntent_APTK = new Intent(Intent.ACTION_DIAL);
		 callIntent_APTK.setData(Uri.parse("tel:032 412 73 29"));
		  callIntent_APTK.setData(Uri.parse("tel:032 412 73 29"));
		  startActivity(callIntent_APTK);
		  
		  APTK_AnrufLabel.setText(labelTelefon +  ": Calling...");
	  	  APTK_AnrufLabel.setTextFill(Color.GREEN);

		 

		  
 
	  }
  
   }
   public void ShowMap(){
	   
		  if(APTK_Map.isPressed()){
		 //RH_MapImage.setImageResource(R.drawable.RehaImage.png);
	    	} 
			  
	 
		  }
    
    //----------------------------------------------------------
	
//    protected void updateAppBar(AppBar appBar) {
//        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> switchView(SECONDARY_VIEW)));
//        appBar.setTitleText("Vor Rehaeintritt");
//    }
    private void startActivity(Intent callIntent) {
    	// TODO Auto-generated method stub
    	
    }
    public void initialize() {
    	apothekekontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	apothekekontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Apotheke");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
            }
        });
    }
}
