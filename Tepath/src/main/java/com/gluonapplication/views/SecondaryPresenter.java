package com.gluonapplication.views;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import com.gluonapplication.GluonApplication;
import com.gluonapplication.MyConn;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class SecondaryPresenter {

    @FXML
    private View ablauf;
    
//    @FXML
//    private GridPane tableAblauf;
    
    @FXML
    private Label ablaufLabel;

    @FXML
    private Accordion legendeInhalt;

    @FXML
    private TitledPane legendeTitel;

    @FXML
    private Circle erledigtSymbol;

    @FXML
    private Label erledigtLabel;

    @FXML
    private CheckBox checkbox;

    @FXML
    private Circle offenSymbol;

    @FXML
    private Label offenLabel;

    @FXML
    private ImageView infoSymbol;

    @FXML
    private Label infoLabel;

    @FXML
    private Circle verschobenSymbol;

    @FXML
    private Label verschobenLabel;

    @FXML
    private Label coundownLabel;
    
    @FXML
    private Label xTage;

	@FXML
    private TableView<Note> tableNotes;

	@FXML
    private TableColumn<Note, String> zustand;

	@FXML
    private TableColumn<Note, String> datum;

	@FXML
    private TableColumn<Note, String> name;
    
//	String PatientID = PrimaryPresenter.PatientID;
    
    private static Connection con;
    private static Statement stat;

    private ObservableList <Note> dataNotes; 

	public void initialize() {
        ablauf.setShowTransitionFactory(BounceInRightTransition::new);
        
        dataNotes = FXCollections.observableArrayList();
        zustand.setCellValueFactory(
                new PropertyValueFactory<Note, String>("zustand")
        );
        datum.setCellValueFactory(
                new PropertyValueFactory<Note, String>("datum")
        );
        name.setCellValueFactory(
                new PropertyValueFactory<Note, String>("name")
        );
        try {            
            MyConn co = new MyConn();
            con = co.getconn();
            stat = con.createStatement();
            String query = "SELECT Zustand, Datum, Name FROM Termine";
//            stat.executeUpdate("CREATE TABLE IF NOT EXISTS NotesDB (idno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Title VARCHAR(500), Description VARCHAR(1000), DateCreated DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL);");
//            String _PatID="";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
//            	_PatID = rs.getString("ID_Patient");
                Note nt = new Note();
                nt.zustand.set(rs.getString("Zustand"));
                nt.datum.set(rs.getString("Datum"));
                nt.name.set(rs.getString("Name"));
                dataNotes.add(nt);
//                PatientID = _PatID;
            }          
            
            	tableNotes.setItems(dataNotes);
        } catch (SQLException ex) {
        	ex.getMessage();
        }
        
//        ablauf.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text, 
//            e -> System.out.println("Info")).getLayer());
        
//        java.util.Date d1 = new GregorianCalendar(2000, 11, 31, 23, 59).getTime();
        
        try {            
            MyConn co = new MyConn();
            con = co.getconn();
            stat = con.createStatement();
            String query = "SELECT Datum FROM Termine";
            ResultSet rs = stat.executeQuery(query);
            Date dann = null;
            while (rs.next()) {
                dann = rs.getDate("Datum");
            }          
            Date d1 = new GregorianCalendar().getTime();
            d1 = dann;
            Date today = new Date();
            long diff = d1.getTime() - today.getTime();
            String noch = String.valueOf(diff);
            xTage.setText(noch);
        } catch (SQLException ex) {
        	ex.getMessage();
        }
        
        ablauf.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                 MobileApplication.getInstance().showLayer(GluonApplication.MENU_LAYER)));
                appBar.setTitleText("Ablauf");
                
            }
        });
    }
}