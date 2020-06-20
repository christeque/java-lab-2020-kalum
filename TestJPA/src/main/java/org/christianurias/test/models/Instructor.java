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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



@Entity
@Table(name = "instructor")
@NamedQueries({@NamedQuery(name = "Instructor.findAll", query = "select i from Instructor i")})  //"from Instructor")})
public class Instructor implements Serializable {
    private final StringProperty instructorId;
    private final StringProperty apellidos;
    private final StringProperty nombres;
    private final StringProperty direccion;
    private final StringProperty telefono;
    private final StringProperty comentario;
    private final StringProperty estatus;
    private final StringProperty foto;
    private final List<Clase> clases;

    public Instructor() {
        this.instructorId = new SimpleStringProperty();
        this.apellidos = new SimpleStringProperty();
        this.nombres = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.comentario = new SimpleStringProperty();
        this.estatus = new SimpleStringProperty();
        this.foto = new SimpleStringProperty();
    }

    @Id
    @Column(name = "instructor_id")
    public String getInstructorId() {
        return instructorId.get();
    }

    public void setInstructorId(final String instructorId) {
        this.instructorId.set(instructorId);
    }

    public StringProperty instructorId() {
        return this.instructorId;
    }

    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(final String apellidos) {

        this.apellidos.set(apellidos);
    }

    public StringProperty apellidos() {
        return this.apellidos;
    }

    @Column(name = "nombres")
    public String getNombres() {
        return nombres.get();
    }

    public void setNombres(final String nombres) {
        this.nombres.set(nombres);
    }

    public StringProperty nombres() {
        return this.nombres;
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(final String direccion) {
        this.direccion.set(direccion);
    }

    public StringProperty direccion() {
        return this.direccion;
    }

    @Column(name = "telefono")
    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(final String telefono) {
        this.telefono.set(telefono);
    }

    public StringProperty telefono() {
        return this.telefono;
    }

    @Column(name = "comentario")
    public String getComentario() {
        return comentario.get();
    }

    public void setComentario(final String comentario) {
        this.comentario.set(comentario);
    }

    public StringProperty comentario() {
        return this.comentario;
    }

    @Column(name = "estatus")
    public String getEstatus() {
        return estatus.get();
    }

    public void setEstatus(final String estatus) {
        this.estatus.set(estatus);
    }

    public StringProperty estatus() {
        return this.estatus;
    }

    @Column(name = "foto")
    public String getFoto() {
        return foto.get();
    }

    public void setFoto(final String foto) {
        this.foto.set(foto);
    }

    public StringProperty foto() {
        return this.foto;
    }

   @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(final List<Clase> clases) {
        this.clases = clases;
    }


    private static final long serialVersionUID = 1L;

}