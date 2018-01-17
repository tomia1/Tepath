package com.gluonapplication.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 * Diese Klasse ordnet die FXML-Datei mit der darstellung der Login Ansicht der
 * Kontroller-Klasse(PrimaryPresenter.java) zu.
 * 
 * @author Hager
 *
 */
public class PrimaryView {

	private final String name;

	public PrimaryView(String name) {
		this.name = name;
	}

	public View getView() {
		try {
			View view = FXMLLoader.load(PrimaryView.class.getResource("login.fxml"));
			view.setName(name);
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View(name);
		}
	}
}
