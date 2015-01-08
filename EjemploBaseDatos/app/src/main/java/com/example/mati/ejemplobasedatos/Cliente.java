package com.example.mati.ejemplobasedatos;

/**
 * Created by mati on 8/01/15.
 */
public class Cliente {

    public String nombre;
    public String telefono;



    public Cliente(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

}
