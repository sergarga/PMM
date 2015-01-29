package com.example.mati.examenpmm;

import java.io.Serializable;

/**
 * Created by mati on 29/01/15.
 */
public class Destino implements Serializable{

    String zona, continente;
    double precio;

    public Destino (String zona, String continente, int precio){

        this.zona = zona;
        this.continente = continente;
        this.precio = precio;

    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return zona+" / "+continente+" / "+precio;
    }
}
