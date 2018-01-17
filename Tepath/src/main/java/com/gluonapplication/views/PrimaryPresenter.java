package com.gluonapplication.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gluonapplication.GluonApplication;
import com.gluonapplication.MyConn;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Diese Klasse ist für den Login des Patienten. Je nachdem welcher Patient sich
 * einloggt, ändern sich dementsprechend auch die dargestellten daten.
 * 
 * @author Hager
 *
 */
public class PrimaryPresenter {

	public java.sql.Connection con;

	@FXML
	private View primary;

	@FXML
	private Button anmelden;

	@FXML
	private TextField userName;

	@FXML
	private PasswordField password;

	@FXML
	private Label message;

	public static String PatientID;

	/**
	 * Wenn sich der richtige Patient mit den richtigen Benutzername und
	 * Passwort anmeldet (welche von der Datenbank geholt werden) kann er sich
	 * einloggen und kommt auf die Ablauf ansicht. Wenn das Passwort oder
	 * Benutzername falsch ist, wird die Nachricht "Benutzername oder Passwort
	 * falsch!"angezeigt.
	 * 
	 * @param event
	 *            login
	 */
	@FXML
	void MakeLogin(ActionEvent event) {

		MyConn co = new MyConn();
		con = co.getconn();
		String query = "Select * from Patienten where Username=? and Password=?";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName.getText());
			pst.setString(2, password.getText());
			ResultSet rs = pst.executeQuery();

			String _user = "";
			String _pass = "";
			String _PatID = "";
			while (rs.next()) {
				_user = rs.getString("Username");
				_pass = rs.getString("Password");
				_PatID = rs.getString("ID_Patient");
			}
			if (_user.equals(userName.getText()) && _pass.equals(password.getText())) {
				PatientID = _PatID;
				System.out.println(PatientID);

				anmelden.setOnAction(e -> MobileApplication.getInstance().switchView(GluonApplication.SECONDARY_VIEW));

			} else {
				message.setText("Benutzername oder Passwort falsch!");
				message.setTextFill(Color.RED);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}

	}

};
