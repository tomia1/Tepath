package com.gluonapplication;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LifecycleService;
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
        
        
        // Die Beschriftung im eingeblendeten Menü ist hier "TEPATH" festgelegt worden.
         //Darunter wird das Icon der Applikation plaziert.
         
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("TEPATH",
                "Menu",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/tep.JPG"))));
        drawer.setHeader(header);
        
        
          //Die Verschiedenen Menüinhalte werden hier erstellt. 
          //Es wird der Name benannt, der Icon der neben dem Namen steht und die Ansicht die geöffnet wird.
         
        final Item startseite = new ViewItem("Startseite", MaterialDesignIcon.HOME.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        final Item ablauf = new ViewItem("Ablauf", MaterialDesignIcon.QUEUE_PLAY_NEXT.graphic(), SECONDARY_VIEW, ViewStackPolicy.SKIP);
        final Item checkliste = new ViewItem("Checklisten", MaterialDesignIcon.CHECK.graphic(), CHECKLIST_VIEW, ViewStackPolicy.SKIP);
        final Item kontakte = new ViewItem("Kontakte", MaterialDesignIcon.CONTACTS.graphic(), KONTAKTE_VIEW, ViewStackPolicy.SKIP);
        final Item gesundh = new ViewItem("Gesundheitszustand", MaterialDesignIcon.HEALING.graphic(), GESUNDHEITSZUSTAND_VIEW, ViewStackPolicy.SKIP);
        drawer.getItems().addAll(startseite, ablauf, checkliste, kontakte, gesundh);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
        
        
         //Wenn im Menü etwas ausgewählt wird und die Seite angezeit wird, verschwindet der Menü-Layer.
         
        
        drawer.addEventHandler(NavigationDrawer.ITEM_SELECTED, 
                e -> MobileApplication.getInstance().hideLayer(MENU_LAYER));
        
        MobileApplication.getInstance().viewProperty().addListener((obs, oldView, newView) -> updateItem(newView.getName()));
        updateItem(PRIMARY_VIEW);
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
