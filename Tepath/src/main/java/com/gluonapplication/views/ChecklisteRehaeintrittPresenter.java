package com.gluonapplication.views;

import com.gluonapplication.GluonApplication;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;

/**
 * Diese Klasse ist die Ansicht mit der Checkliste f�r die Vorbereitung in das
 * Rehazentrum.
 * 
 * @author Hager
 *
 */
public class ChecklisteRehaeintrittPresenter {

	@FXML
	private View rehaeintritt;

	public void initialize() {
		rehaeintritt.setShowTransitionFactory(BounceInRightTransition::new);
		rehaeintritt.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(MaterialDesignIcon.MENU
						.button(e -> MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
				appBar.setTitleText("Vor Rehaeintritt");
				appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK
						.button(e -> MobileApplication.getInstance().switchToPreviousView()));
			}
		});
	}
}
