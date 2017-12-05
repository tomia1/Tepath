package com.gluonapplication;

import com.gluonapplication.views.ChecklistView;
import com.gluonapplication.views.GesundheitszustandView;
import com.gluonapplication.views.KontakteView;
import com.gluonapplication.views.PrimaryView;
import com.gluonapplication.views.SecondaryView;
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
	public static final String CHECKLIST_VIEW = "Checklisten";
	public static final String KONTAKTE_VIEW = "Kontakte";
	public static final String GESUNDHEITSZUSTAND_VIEW = "Gesundheitszustand";
    
    @Override
    public void init() {
    	addViewFactory(PRIMARY_VIEW, () -> new PrimaryView(PRIMARY_VIEW).getView());
        addViewFactory(SECONDARY_VIEW, () -> new SecondaryView(SECONDARY_VIEW).getView());
        addViewFactory(CHECKLIST_VIEW, ()-> new ChecklistView(CHECKLIST_VIEW).getView());
        addViewFactory(KONTAKTE_VIEW, () -> new KontakteView(KONTAKTE_VIEW).getView());
        addViewFactory(GESUNDHEITSZUSTAND_VIEW, () -> new GesundheitszustandView(GESUNDHEITSZUSTAND_VIEW).getView());
        
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/tep.JPG")));
    }
}
