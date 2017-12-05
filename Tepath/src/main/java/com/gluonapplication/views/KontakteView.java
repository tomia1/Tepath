package com.gluonapplication.views;

import java.io.IOException;

import com.gluonhq.charm.glisten.mvc.View;

import javafx.fxml.FXMLLoader;

public class KontakteView {
	
	  private final String name;

	    public KontakteView(String name) {
	        this.name = name;
	    }
	    
	    public View getView() {
	        try {
	            View view = FXMLLoader.load(KontakteView.class.getResource("kontakte.fxml"));
	            view.setName(name);
	            return view;
	        } catch (IOException e) {
	            System.out.println("IOException: " + e);
	            return new View(name);
	        }
	    }

}
