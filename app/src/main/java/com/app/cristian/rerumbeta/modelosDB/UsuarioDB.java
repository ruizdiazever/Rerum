package com.app.cristian.rerumbeta.modelosDB;

import com.orm.SugarRecord;

/**
 * Created by Cristian on 22/05/2017.
 */

public class UsuarioDB extends SugarRecord {
    String usuario;
    String contrasena;

    //CONSTRUCTOR
    public  UsuarioDB(){
    }
    public UsuarioDB(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //GETTERS

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    //SETTERS

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contraseña) {
        contrasena = contraseña;
    }
}
