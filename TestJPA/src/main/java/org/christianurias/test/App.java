package org.christianurias.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javafx.application.Application;
import javafx.stage.Stage;

//import javax.persistence.Id;
//import javax.persistence.Query;
//import javax.persistence.StoredProcedureQuery;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import org.christianurias.test.controllers.VentanaClaseController;
import org.christianurias.test.controllers.VentanaPrincipalController;
import org.christianurias.test.controllers.VentanaSalonAddUpdateController;
import org.christianurias.test.controllers.VentanaSalonController;
import org.christianurias.test.db.Conexion;
import org.christianurias.test.models.CarreraTecnica;
import org.christianurias.test.models.Salon;

public class App extends Application {
    private final String PAQUETE_VISTAS = "/org/christianurias/test/views/";

    private Stage escenarioPrincipal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("kalum V1.0.0");
        mostrarVentanaPrincipal();
        // mostrarVentanaClases();
        this.escenarioPrincipal.show();
    }

    public void mostrarVentanaPrincipal() {
        try {
            VentanaPrincipalController ventanaPrincipalView = (VentanaPrincipalController) cambiarEscena("VentanaPrincipalView.fxml", 640, 375);
            ventanaPrincipalView.setDirectorEscena(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalon() {
        try {
            VentanaSalonController ventanaSalonView = (VentanaSalonController) cambiarEscena("VentanaSalonView.fxml",600, 372);
            ventanaSalonView.setDirectorEscenas(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalonAddUpdate() {
        try {
            VentanaSalonAddUpdateController ventanaSalonAddUpdate = (VentanaSalonAddUpdateController) cambiarEscena("VentanaSalonAddUpdateView.fxml", 600, 324);
            ventanaSalonAddUpdate.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalonAddUpdate(Salon salon) {
        try {
            VentanaSalonAddUpdateController ventanaSalonAddUpdate = (VentanaSalonAddUpdateController) cambiarEscena("VentanaSalonAddUpdateView.fxml", 600, 324);
            ventanaSalonAddUpdate.setDirectorEscenas(this);
            ventanaSalonAddUpdate.setSalon(salon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








    public void mostrarVentanaClases() {
        try {
            VentanaClaseController ventanaClaseView = (VentanaClaseController) cambiarEscena("ClaseView.fxml", 686,
                    400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Initializable cambiarEscena(String escena, int ancho, int alto) throws IOException {
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivoFXML = App.class.getResourceAsStream(PAQUETE_VISTAS + escena);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(App.class.getResource(PAQUETE_VISTAS + escena));
        Scene miEscena = new Scene((AnchorPane) cargadorFXML.load(archivoFXML), ancho, alto);
        this.escenarioPrincipal.setScene(miEscena);
        this.escenarioPrincipal.sizeToScene();
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;

    }
}

/*
 * Conexion conexion = new Conexion(); for (Object registro :
 * conexion.findAll("CarreraTecnica.findAll")) { CarreraTecnica carrera =
 * (CarreraTecnica) registro; System.out.println(carrera.getCarreraId() + " " +
 * carrera.getNombreCarrera());
 */
