package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import static com.gluonapplication.GluonApplication.MENU_LAYER;
import static com.gluonapplication.GluonApplication.PRIMARY_VIEW;
import static com.gluonapplication.GluonApplication.SECONDARY_VIEW;
import static com.gluonapplication.GluonApplication.CHECKLIST_VIEW;
import static com.gluonapplication.GluonApplication.KONTAKTE_VIEW;
import static com.gluonapplication.GluonApplication.GESUNDHEITSZUSTAND_VIEW;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class DrawerManager {


	private final NavigationDrawer drawer;   

    public DrawerManager() {
        this.drawer = new NavigationDrawer();
        
        
        // Die Beschriftung im eingeblendeten Men� ist hier "TEPATH" festgelegt worden.
         //Darunter wird das Icon der Applikation plaziert.
         
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("TEPATH",
                "Menu",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/tep.JPG"))));
        drawer.setHeader(header);
        
        
          //Die Verschiedenen Men�inhalte werden hier erstellt. 
          //Es wird der Name benannt, der Icon der neben dem Namen steht und die Ansicht die ge�ffnet wird.
         
        
        final Item ablauf = new ViewItem("Ablauf", MaterialDesignIcon.QUEUE_PLAY_NEXT.graphic(), SECONDARY_VIEW, ViewStackPolicy.SKIP);
        final Item checkliste = new ViewItem("Checklisten", MaterialDesignIcon.CHECK.graphic(), CHECKLIST_VIEW, ViewStackPolicy.SKIP);
        final Item kontakte = new ViewItem("Kontakte", MaterialDesignIcon.CONTACTS.graphic(), KONTAKTE_VIEW, ViewStackPolicy.SKIP);
        final Item gesundh = new ViewItem("Gesundheitszustand", MaterialDesignIcon.HEALING.graphic(), GESUNDHEITSZUSTAND_VIEW, ViewStackPolicy.SKIP);
        final Item quit = new ViewItem("Abmelden", MaterialDesignIcon.EXIT_TO_APP.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        drawer.getItems().addAll(ablauf, checkliste, kontakte, gesundh, quit);
        

        
        
         //Wenn im Men� etwas ausgew�hlt wird und die Seite angezeit wird, verschwindet der Men�-Layer.
         
        
        drawer.addEventHandler(NavigationDrawer.ITEM_SELECTED, 
                e -> MobileApplication.getInstance().hideLayer(MENU_LAYER));
        
        MobileApplication.getInstance().viewProperty().addListener((obs, oldView, newView) -> updateItem(newView.getName()));
        updateItem(SECONDARY_VIEW);
    }
    
    private void updateItem(String nameView) {
        for (Node item : drawer.getItems()) {
            if (item instanceof ViewItem && ((ViewItem) item).getViewName().equals(nameView)) {
                drawer.setSelectedItem(item);
                break;
            }
        }
    }
    
    public NavigationDrawer getDrawer() {
        return drawer;
    }
}
