package org.christianurias.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.christianurias.test.App;
import org.christianurias.test.db.Conexion;
import org.christianurias.test.models.Salon;

public class VentanaSalonAddUpdateController implements Initializable {

    @FXML
    private TextField txtSalon;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtCapacidad;

    private App directorEscenas;
    private Salon salon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void guardar() {
        if (txtSalon.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCapacidad.getText().isEmpty()
                || Integer.parseInt(txtCapacidad.getText()) <= 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Error de entrada de datos, es necesario ingresar la informacion de forma correcta");
            alert.initOwner(null);
            alert.show();
        } else {
            if(salon != null){
            salon.setNombreSalon(txtSalon.getText());
            salon.setDescripcion(txtDescripcion.getText());
            salon.setCapacidad(txtCapacidad.getText());
            Conexion.getIntancia().modificar(salon);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Registro actualizado correctamente");
            alert.initOwner(null);
            alert.show();
            this.directorEscenas.mostrarVentanaSalon();

            }else {
            salon = new Salon();
            salon.setSalonId(UUID.randomUUID().toString());
            salon.setNombreSalon(txtSalon.getText());
            salon.setDescripcion(txtDescripcion.getText());
            salon.setCapacidad(txtCapacidad.getText());
            Conexion.getIntancia().agregar(salon);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Registro almacenado correctamente");
            alert.initOwner(null);
            alert.show();
            this.directorEscenas.mostrarVentanaSalon();
        }
    }

    }

    public void cancelar() {
        this.directorEscenas.mostrarVentanaSalon();
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
        this.txtSalon.setText(salon.getNombreSalon());
        this.txtDescripcion.setText(salon.getDescripcion());
        this.txtCapacidad.setText(salon.getCapacidad());
    }

    



}






