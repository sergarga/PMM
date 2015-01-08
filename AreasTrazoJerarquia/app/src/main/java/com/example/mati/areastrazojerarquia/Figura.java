package com.example.mati.areastrazojerarquia;


import java.io.Serializable;

public class Figura implements Serializable
{
    protected String tipo;

    /** Constructor por defecto: crea una figura por defecto de color negro (Color.black) y tipo "indefinido" */
    public Figura() {
        tipo = "indefinido";
    }
    
    public Figura(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() { 
        return tipo;
    }
    
    public String toString(){
        return "Figura de tipo: " + tipo;
    }
        
    /** Devuelve el true si la figura actual es igual a la que recibe como par�metro.
     *  Se considera que dos figuras son iguales si tienen el mismo tipo y color */
    public boolean equals(Object x) {
        Figura f = (Figura) x;
        return tipo.equals(f.tipo);
    }
}