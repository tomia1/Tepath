package com.gluonapplication.views;

import java.io.IOException;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

public class ChecklisteSpezialistenbesuchView {
	
	private final String name;

    public ChecklisteSpezialistenbesuchView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(ChecklisteSpezialistenbesuchView.class.getResource("checklisteSpezialistenbesuch.fxml"));
            view.setName(name);
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View(name);
        }
    }

}