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
 * Diese Klasse beinhaltet die Darstellung der Kontaktinformationen des
 * Spezialisten.
 * 
 * @author Hager
 *
 */
public class Spezialistkontakt1Presenter {

	public java.sql.Connection con;

	@FXML
	private View spezialistkontakt;

	@FXML
	private Label labelNameSP;

	@FXML
	private Label labelStrasseSP;

	@FXML
	private Label labelTelefonSP;

	@FXML
	private Label labelMail;

	String PatientID = PrimaryPresenter.PatientID;

	/**
	 * Es wird der Name, Adresse und Telefonnummer des Spezialisten aus der
	 * Datenbank geholt, welche bei den eingeloggten Patienten abgespeichert
	 * worden sind.
	 */
	public void initialize() {

		try {

			MyConn co = new MyConn();
			con = co.getconn();
			Statement st = con.createStatement();
			String query3 = "SELECT dbo.Spezialist.Name, dbo.Spezialist.Adresse, "
					+ "dbo.Spezialist.Telefon FROM dbo.Spezialist INNER JOIN "
					+ "dbo.Patienten ON dbo.Spezialist.ID_Spezialist = " + "dbo.Patienten.Spezialist "
					+ " Where (dbo.Patienten.ID_Patient =" + PatientID + ")";

			ResultSet rs = st.executeQuery(query3);

			String _Name = "";
			String _Strasse = "";
			String _Telefon = "";
			while (rs.next()) {
				_Name = rs.getString("Name");
				_Strasse = rs.getString("Adresse");
				_Telefon = rs.getString("Telefon");

				labelNameSP.setText(_Name);
				labelStrasseSP.setText(_Strasse);
				labelTelefonSP.setText(_Telefon);
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
		/**
		 * Die ApplikationsBar beinhaltet die Ueberschrift "Spezialist" sowie
		 * das Menue-Icon und eine Pfeil nach links, mit dessen Hilfe man auf
		 * die vorherige Seite(Kontakte) gelangt.
		 */
		spezialistkontakt.setShowTransitionFactory(BounceInRightTransition::new);
		spezialistkontakt.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(MaterialDesignIcon.MENU
						.button(e -> MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
				appBar.setTitleText("Spezialist");
				appBar.getActionItems().add(MaterialDesignIcon.ARROW_BACK
						.button(e -> MobileApplication.getInstance().switchToPreviousView()));
			}
		});
	}
}
