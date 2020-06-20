package org.christianurias.test.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "salon")
@NamedQueries(@NamedQuery(name = "Salon.finAll", query = "select s from Salon s"))
public class Salon implements Serializable {
    private final StringProperty salonId;
    private final StringProperty nombreSalon;
    private final StringProperty descripcion;
    private final IntegerProperty capacidad;

    private List<Clase> clases;

    public Salon() {
        this.salonId = new SimpleStringProperty();
        this.nombreSalon = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.capacidad = new SimpleIntegerProperty();
    }

    @OneToMany(mappedBy = "salon", fetch = FetchType.EAGER)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    @Id
    @Column(name = "salon_id")
    public String getSalonId() {
        return this.salonId.get();
    }

    public void setSalonId(String salonId) {
        this.salonId.set(salonId);
    }

    public StringProperty salonId() {
        return this.salonId;
    }

    @Column(name = "nombre_salon")
    public String getNombreSalon() {
        return nombreSalon.get();
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon.set(nombreSalon);
    }

    public StringProperty nombreSalon() {
        return this.nombreSalon;
    }
    // hola//

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcion() {
        return this.descripcion;
    }

    @Column(name = "capacidad")
    public int getCapacidad() {
        return this.capacidad.get();
    }

    public void setCapacidad(int capacidad) {
        this.capacidad.set(capacidad);
    }

    public IntegerProperty capacidad() {
        return this.capacidad;
    }


    @Override
    public String toString() {
        return this.getSalonId() + ' ' + this.getDescripcion() + ' ' + this.getNombreSalon() + ' ' + this.getCapacidad();
    }


    private static final long serialVersionUID = 1L;


}