package com.gluonapplication;

import com.gluonapplication.views.ChecklistView;
import com.gluonapplication.views.ChecklisteRehaeintrittView;
import com.gluonapplication.views.ChecklisteSpitaleintrittView;
import com.gluonapplication.views.GesundheitszustandView;
import com.gluonapplication.views.HausarztkontaktView;
import com.gluonapplication.views.KontakteView;
import com.gluonapplication.views.PrimaryView;
import com.gluonapplication.views.SecondaryView;
import com.gluonapplication.views.SpitalkontaktView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {

	public static final String PRIMARY_VIEW = HOME_VIEW; // primaryView ist die Startseite
    public static final String SECONDARY_VIEW = "Ablauf"; // secondaryView ist die Ablaufseite
    public static final String MENU_LAYER = "Side Menu";
	public static final String CHECKLIST_VIEW = "Checklisten"; // die Sicht mit den Checklisten
	public static final String KONTAKTE_VIEW = "Kontakte"; // Konatkpersonen
	public static final String GESUNDHEITSZUSTAND_VIEW = "Gesundheitszustand"; // Gesundheitszustand des Patientin
	public static final String CHECKLISTESPITALEINTRITT_VIEW = "Spitaleintritt";// Checkliste vor Spitaleintritt
	public static final String CHECKLISTESPEZIALISTENBESUCH_VIEW = "Spezialistenbesuch";// Chekliste vor Speizalistenbesuch
	public static final String CHECKLISTEREHAEINTRITT_VIEW = "Rehaeintritt";// Checkliste vor Rehaeintritt
	public static final String HAUSARZTKONTAKT_VIEW = "Hausarztkontakt";// Kontakt _Hausazrt
	public static final String SPITALKONTAKT_VIEW = "Spitalkontakt";// Kontakt_Spital
	public static final String APOTHEKEKONTAKT_VIEW = "Apothekekontakt";// Kontakt_Apotheke
	public static final String REHAKONTAKT_VIEW = "Rehakontakt";// Kontakt_Reha
	public static final String SPEZIALISTKONTAKT_VIEW = "Spezialistkontakt";//Kontakt_Spezialist
    @Override
    public void init() {
    	
    	 //Hier werden die verschiedenen Sichten der Applikation erstellt.
    	 //Das Menü wird auch hier erstellt. Das Menü wird auf der linken Seite eingeblendet.
    	 
    	addViewFactory(PRIMARY_VIEW, () -> new PrimaryView(PRIMARY_VIEW).getView());
        addViewFactory(SECONDARY_VIEW, () -> new SecondaryView(SECONDARY_VIEW).getView());
        addViewFactory(CHECKLIST_VIEW, () -> new ChecklistView(CHECKLIST_VIEW).getView());
        addViewFactory(KONTAKTE_VIEW, () -> new KontakteView(KONTAKTE_VIEW).getView());
        addViewFactory(GESUNDHEITSZUSTAND_VIEW, () -> new GesundheitszustandView(GESUNDHEITSZUSTAND_VIEW).getView());
        addViewFactory(CHECKLISTESPITALEINTRITT_VIEW, () -> new ChecklisteSpitaleintrittView(CHECKLISTESPITALEINTRITT_VIEW).getView());
        addViewFactory(CHECKLISTESPEZIALISTENBESUCH_VIEW, () -> new ChecklisteSpitaleintrittView(CHECKLISTESPEZIALISTENBESUCH_VIEW).getView());
        addViewFactory(CHECKLISTEREHAEINTRITT_VIEW, () -> new ChecklisteRehaeintrittView(CHECKLISTEREHAEINTRITT_VIEW).getView());
        addViewFactory(HAUSARZTKONTAKT_VIEW, () -> new HausarztkontaktView(HAUSARZTKONTAKT_VIEW).getView());
        addViewFactory(SPITALKONTAKT_VIEW, () -> new SpitalkontaktView(SPITALKONTAKT_VIEW).getView());
        addViewFactory(APOTHEKEKONTAKT_VIEW, () -> new SpitalkontaktView(APOTHEKEKONTAKT_VIEW).getView());
        addViewFactory(REHAKONTAKT_VIEW, () -> new SpitalkontaktView(REHAKONTAKT_VIEW).getView());
        addViewFactory(SPEZIALISTKONTAKT_VIEW, () -> new SpitalkontaktView(SPEZIALISTKONTAKT_VIEW).getView());
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene); // Die Farbe AppBar ist hier blau.

        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/tep.JPG")));
    }
}
