package com.gluonapplication.views;

import java.io.IOException;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;
/**
 * Diese Klasse ist Zuständig dafür, dass die FXML-Datei der
 * Kontroller-KLasse(Rehakontakt1Presenter.java) auch darin angezeigt wird.
 * 
 * @author Hager
 *
 */
public class Rehakontakt1View {
	
	private final String name;

    public Rehakontakt1View(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(Rehakontakt1View.class.getResource("Rehakontakt.fxml"));
            view.setName(name);
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View(name);
        }
    }

}
