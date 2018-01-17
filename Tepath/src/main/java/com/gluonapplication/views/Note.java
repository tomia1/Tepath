package com.gluonapplication.views;

import javafx.beans.property.SimpleStringProperty;

public class Note {

    public  SimpleStringProperty zustand = new SimpleStringProperty();
    public  SimpleStringProperty datum = new SimpleStringProperty();
    public  SimpleStringProperty name = new SimpleStringProperty();
	

    public String getZustand() {
        return zustand.get();
    }

    public void setZustand(String zustandStr) {
        zustand.set(zustandStr);
    }

    public String getDatum() {
        return datum.get();
    }

    public void setDatum(String datumStr) {
        datum.set(datumStr);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String nameStr) {
        name.set(nameStr);
    }
	
}