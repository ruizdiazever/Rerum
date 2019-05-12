package com.app.cristian.rerumbeta.modelosDB;

import com.orm.SugarRecord;

/**
 * Created by Cristian on 22/05/2017.
 */

public class EventosDB extends SugarRecord {

    String titulo ;
    String descripcion;
    String resumen;
    String fechaInicio;
    String fechaFinal;
    String fechaDePublicacion;
    String imagen;
    String Hora;
    String minutos;
    String categoria;

    //Constructores

    public EventosDB(){
    }

    public EventosDB(String titulo, String descripcion, String resumen, String fechaInicio, String fechaFinal, String fechaDePublicacion, String imagen, String hora, String minutos, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaDePublicacion = fechaDePublicacion;
        this.imagen = imagen;
        this.Hora = hora;
        this.minutos = minutos;
        this.categoria = categoria;

    }

    //GETTERS

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getHora() {
        return Hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public String getCategoria() {
        return categoria;
    }

    //SETTERS

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
