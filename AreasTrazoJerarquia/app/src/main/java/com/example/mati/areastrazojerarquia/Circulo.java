package com.example.mati.areastrazojerarquia;

import android.graphics.Color;

public class Circulo extends Figura
{
    protected float radio;
    
    /** Constructor por defecto: crea un c�rculo de color negro (Color.black) y radio 10.0  */
    public Circulo() {
        super("circulo");
        radio = 10;
    }
    public Circulo(float radio) {
        super("circulo");
        this.radio = radio;
    }
    
    public float getRadio() {
        return this.radio;
    }
    
    public void setRadio(float radio) {
        this.radio = radio;
    }
    
    public float area() {
        return (float)(Math.PI) * radio * radio;
    }
        
    public String toString(){
        return "Circulo de radio " + radio;
    }
}
