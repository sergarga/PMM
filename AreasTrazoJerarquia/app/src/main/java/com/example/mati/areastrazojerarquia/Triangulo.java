package com.example.mati.areastrazojerarquia;

/**
 * Created by mati on 18/12/14.
 */
public class Triangulo extends Figura{

        protected float base;
        protected float altura;

        /** Constructor por defecto: crea un rect�ngulo de color negro (Color.black), base 10.0 y altura 10.0   */
        public Triangulo() {
            super("triangulo");
            base = 10;
            altura = 10;
        }

        public Triangulo(float altura, float base){
            super("triangulo");
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
            return (base * altura)/2;
        }

        public String toString() {
            return "Triangulo de base " + base + " y altura " + altura;
        }

}

