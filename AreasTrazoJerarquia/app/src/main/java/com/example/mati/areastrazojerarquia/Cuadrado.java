package com.example.mati.areastrazojerarquia;

public class Cuadrado extends Rectangulo
{
    /** Constructor por defecto: crea un cuadrado de color negro (Color.black) y lado 10.0      */
    public Cuadrado()
    {   super();
        tipo = "cuadrado";
    }

    public Cuadrado(float lado){
        super(lado, lado);
        tipo = "cuadrado";
    }
    
    public float getLado() {
        return base;
    }
        
     public void setLado(float lado) {
        base = altura = lado;
    }
    
    public void setBase(float base) {
        this.base = this.altura = base;
    }
    
    public void setAltura(float altura) {
        this.base = this.altura = altura;
    }
    
    public String toString(){
        return "Cuadrado de lado " + getLado();
    }
}
