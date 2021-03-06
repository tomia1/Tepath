package com.gluonapplication.views;

import java.io.IOException;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

/**
 * Diese Klasse ist Zust�ndig daf�r, dass die FXML-Datei der
 * Kontroller-KLasse(Hausarztkontakt1Presenter.java) auch darin angezeigt wird.
 * 
 * @author Hager
 *
 */
public class Hausarztkontakt1View {

	private final String name;

	public Hausarztkontakt1View(String name) {
		this.name = name;
	}

	public View getView() {
		try {
			View view = FXMLLoader.load(Hausarztkontakt1View.class.getResource("hausarztkontakt1.fxml"));
			view.setName(name);
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View(name);
		}
	}

}
