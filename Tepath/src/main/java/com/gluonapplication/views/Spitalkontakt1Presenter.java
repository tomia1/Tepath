package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
//import com.gluonhq.charm.down.plugins.android;

import android.content.Intent;
import android.net.Uri;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Spitalkontakt1Presenter  {
	

    @FXML
    private View spitalkontakt;
    
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

   // @FXML
//    private Label labelMail;
//    void emailSenden(){
//    	labelE.setOnAction(e -> 
//    	sendEmail());
   // }
  //--------------------------------------------------------------
    @FXML
    private Label SPT_AnrufLabel;
  @FXML
  private Button SPT_Anrufen;
  @FXML
  private Button SPT_Map;
  @FXML
  private HBox SPT_MapImage;
  
//  @FXML
//  private image=
//  image = (ImageView) findViewById(R.id.mapImage)
  void SPTanrufen(){
	  if(SPT_Anrufen.isPressed()){
		 
		SPT_AnrufLabel.setText(labelTelefon +  ": Calling...");
  		SPT_AnrufLabel.setTextFill(Color.GREEN);

	    	} 
 
	  }
  
   public void CallSptial(){
	   
	  if(SPT_Anrufen.isPressed()){
		 Intent callIntent_SPT = new Intent(Intent.ACTION_DIAL);
		 callIntent_SPT.setData(Uri.parse("tel:032 324 24 24"));
		  callIntent_SPT.setData(Uri.parse("tel:032 324 24 24"));
		  startActivity(callIntent_SPT);
		  
		  SPT_AnrufLabel.setText(labelTelefon +  ": Calling...");
	  	  SPT_AnrufLabel.setTextFill(Color.GREEN);

	  
 
	  }
  
   }
   public void ShowMap(){
	   
		  if(SPT_Map.isPressed()){
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
    	spitalkontakt.setShowTransitionFactory(BounceInRightTransition::new);
    	spitalkontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Spital");
                appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK.button(e -> 
                MobileApplication.getInstance().switchToPreviousView()));
               
                
            }
        });
    }
}
