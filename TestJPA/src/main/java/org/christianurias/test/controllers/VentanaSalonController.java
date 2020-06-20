package org.christianurias.test.controllers;

import java.util.Observable;
import java.util.ResourceBundle;

import org.christianurias.test.App;
import org.christianurias.test.db.Conexion;
import org.christianurias.test.models.Salon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;


public class VentanaSalonController implements Initializable {

    private App directorEscenas;
    private ObservableList<Salon> listaSalones;
    @FXML
    private TableView<Salon> tblSalon;
    @FXML
    private TableColumn<Salon, String> colSalon;
    @FXML
    private TableColumn<Salon, String> colDescripcion;
    @FXML
    private TableColumn<Salon, Number> colCapacidad;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.listaSalones = FXCollections.observableArrayList((List<Salon>)
                Conexion.getIntancia().findAll("Salon.findAll"));
        this.tblSalon.setItems(this.listaSalones);
        this.colSalon.setCellValueFactory(cellSalon->cellSalon.getValue().nombreSalon());
        this.colDescripcion.setCellValueFactory(cellDescripcion->cellDescripcion.getValue().descripcion());
        this.colCapacidad.setCellValueFactory(cellCapacidad->cellCapacidad.getValue().capacidad());
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public void mostrarVentanaPrincipal() {
        this.directorEscenas.mostrarVentanaPrincipal();
    }

    public void mostrarVentanaSalonAddUpdate() {
        this.directorEscenas.mostrarVentanaSalonAddUpdate();
    }

    public void modificar(){
        if(this.tblSalon.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un elemento");
            alert.initOwner(null);
            alert.show();
        }else {
            Salon salon = this.tblSalon.getSelectionModel().getSelectedItem();
            this.directorEscenas.mostrarVentanaSalonAddUpdate(salon);
        }

    }

    //public VentanaSalonController(App directorEscenas) {
     //   this.directorEscenas = directorEscenas;
    //}
}