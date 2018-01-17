package com.gluonapplication.views;

import java.sql.ResultSet;
import java.sql.Statement;

import com.gluonapplication.GluonApplication;
import com.gluonapplication.MyConn;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Diese Klasse beinhaltet die Darstellung der Kontaktinformationen der
 * Apotheke.
 * 
 * @author Hager
 *
 */
public class Apothekekontakt1Presenter {

	public java.sql.Connection con;

	@FXML
	private View apothekekontakt;

	@FXML
	private Label labelNameAP;

	@FXML
	private Label labelStrasseAP;

	@FXML
	private Label labelTelefonAP;

	@FXML
	private Label labelMail;

	String PatientID = PrimaryPresenter.PatientID;

	/**
	 * Es wird der Name, Adresse und Telefonnummer der Apotheke aus der
	 * Datenbank geholt, welche bei den eingeloggten Patienten abgespeichert
	 * worden sind.
	 */
	public void initialize() {

		try {

			MyConn co = new MyConn();
			con = co.getconn();
			Statement st = con.createStatement();
			String query3 = "SELECT dbo.Apothek.Name, dbo.Apothek.Adresse, "
					+ "dbo.Apothek.Telefon FROM dbo.Apothek INNER JOIN " + "dbo.Patienten ON dbo.Apothek.ID_Apotheke = "
					+ "dbo.Patienten.Apotheke " + " Where (dbo.Patienten.ID_Patient =" + PatientID + ")";

			ResultSet rs = st.executeQuery(query3);

			String _Name = "";
			String _Strasse = "";
			String _Telefon = "";
			while (rs.next()) {
				_Name = rs.getString("Name");
				_Strasse = rs.getString("Adresse");
				_Telefon = rs.getString("Telefon");

				labelNameAP.setText(_Name);
				labelStrasseAP.setText(_Strasse);
				labelTelefonAP.setText(_Telefon);
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
		/**
		 * Die ApplikationsBar beinhaltet die Ueberschrift "Apotheke" sowie das
		 * Menue-Icon und eine Pfeil nach links, mit dessen Hilfe man auf die
		 * vorherige Seite(Kontakte) gelangt.
		 */
		apothekekontakt.setShowTransitionFactory(BounceInRightTransition::new);
		apothekekontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(MaterialDesignIcon.MENU
						.button(e -> MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
				appBar.setTitleText("Apotheke");
				appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK
						.button(e -> MobileApplication.getInstance().switchToPreviousView()));
			}
		});
	}
}
