package org.christianurias.test.controllers;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import org.christianurias.test.db.Conexion;
import org.christianurias.test.models.Clase;

public class VentanaClaseController implements Initializable {

    @FXML
    private TableView<Clase> tblClases;
    @FXML
    private TableColumn<Clase, String> colDescripcion;
    @FXML
    private TableColumn<Clase, String> colCarrera;
    @FXML
    private TableColumn colHorario;
    @FXML
    private TableColumn colInstructor;
    @FXML
    private TableColumn colSalon;
    @FXML
    private TableColumn colCiclo;
    @FXML
    private TableColumn colCupoMaximo;

    private ObservableList<Clase> listaClases;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.listaClases = FXCollections.observableArrayList((List<Clase>) Conexion.getIntancia().findAll("Clase.findAll"));
        this.tblClases.setItems(this.listaClases);
        this.colDescripcion.setCellValueFactory(cellDescripcion -> cellDescripcion.getValue().descripcion());
        this.colCarrera.setCellValueFactory(cellInstructor -> cellInstructor.getValue().getInstructor().apellidos());
        this.colCarrera.setCellValueFactory(cellCarrera -> cellCarrera.getValue().getCarreraTecnica().nombreCarrera());


    }

}