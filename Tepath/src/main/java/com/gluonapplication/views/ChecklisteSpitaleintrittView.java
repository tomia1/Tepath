package com.gluonapplication.views;

import java.io.IOException;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

/**
 * Diese Klasse ordnet die erstellte FXML-Datei für die Ansicht der
 * Spitaleintritt-Checkliste der
 * Kontroller-Klasse(ChecklisteSpitaleintrittPresenter.java) zu.
 * 
 * @author Hager
 *
 */
public class ChecklisteSpitaleintrittView {

	private final String name;

	public ChecklisteSpitaleintrittView(String name) {
		this.name = name;
	}

	public View getView() {
		try {
			View view = FXMLLoader
					.load(ChecklisteSpitaleintrittView.class.getResource("checklisteSpitaleintritt.fxml"));
			view.setName(name);
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View(name);
		}
	}

}
