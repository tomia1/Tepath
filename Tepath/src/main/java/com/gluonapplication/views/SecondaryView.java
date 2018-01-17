package com.gluonapplication.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 * Diese Klasse ordnet die FXML-Datei mit der Darstellung der Ablauf Ansicht der
 * Kontroller-Klasse(SecondaryPresenter.java) zu.
 * 
 * @author Hager
 *
 */
public class SecondaryView {

	private final String name;

	public SecondaryView(String name) {
		this.name = name;
	}

	public View getView() {
		try {
			View view = FXMLLoader.load(SecondaryView.class.getResource("Ablauf.fxml"));
			view.setName(name);
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View(name);
		}
	}
}
