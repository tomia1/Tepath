package com.gluonapplication.views;

import java.io.IOException;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

/**
 * Diese Klasse bindet die erstellte FXML-Datei f�r die Ansicht Checklisten an.
 * 
 * @author Hager
 *
 */
public class ChecklistView {

	private final String name;

	public ChecklistView(String name) {
		this.name = name;
	}

	public View getView() {
		try {
			View view = FXMLLoader.load(ChecklistView.class.getResource("checklist.fxml"));
			view.setName(name);
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View(name);
		}
	}

}
