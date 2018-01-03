package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import android.content.Intent;
import android.net.Uri;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
  //--------------------------------------------------------------
    @FXML
    private Label SPZ_AnrufLabel;
  @FXML
  private Button SPZ_Anrufen;
  @FXML
  private Button SPZ_Map;
  @FXML
  private HBox SPZ_MapImage;
  
//  @FXML
//  private image=
//  image = (ImageView) findViewById(R.id.mapImage)

  
   public void CallSpezialist(){
	   
	  if(SPZ_Anrufen.isPressed()){
		  Intent callIntent_SPZ = new Intent(Intent.ACTION_DIAL);
		 callIntent_SPZ.setData(Uri.parse("tel:044 325 04 10"));
		  callIntent_SPZ.setData(Uri.parse("tel:044 325 04 10"));
		  startActivity(callIntent_SPZ);
		  
		  SPZ_AnrufLabel.setText(labelTelefon +  ": Calling...");
	  	  SPZ_AnrufLabel.setTextFill(Color.GREEN);

		 
	  
 
	  }
  
   }
   public void ShowMap_SPZ(){
	   
		  if(SPZ_Map.isPressed()){
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
