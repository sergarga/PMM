package com.example.mati.areastrazojerarquia;

import android.graphics.Color;

public class Rectangulo extends Figura
{
    protected float base;
    protected float altura;
    
    /** Constructor por defecto: crea un rect�ngulo de color negro (Color.black), base 10.0 y altura 10.0   */
    public Rectangulo() {
        super("rectangulo");
        base = 10;
        altura = 10;
    }

    public Rectangulo(float altura, float base){
        super("rectangulo");
        this.base = base;
        this.altura = altura;
    }
    
    public float getBase() {
        return base;
    }
    
    public float getAltura() {
        return altura;
    }
    
    public void setBase(float base) {
        this.base = base;
    }
    
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float area(){
        return base * altura;
    }
    
    public String toString() {
        return "Rectangulo de base " + base + " y altura " + altura;
    }

 }