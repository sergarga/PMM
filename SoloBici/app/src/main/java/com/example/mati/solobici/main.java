package com.example.mati.solobici;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class main extends Activity {

    private Button bAcercaDe;
    private Button bJuego;
    private Button bPreferencias;
    private Button bSalir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Boton y escuchador para la pantalla "Juego"
        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarJuego();
            }
        });

        bPreferencias = (Button) findViewById(R.id.Boton02);
        bPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View viw){
                lanzarPreferencias();
            }
        });

        //Boton y escuchador para la pantalla "Acerca de"
        bAcercaDe = (Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe();
            }
        });
        /*Boton y escuchador para la pantalla "Salir"*/
        bSalir = (Button) findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarSalir();
            }
        });
    }

        //Metodo que activa la pantalla Juego

    public void lanzarJuego() {
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }

    public void lanzarPreferencias(){
        Intent i = new Intent(this, EjemploPreferencias.class);
        startActivity(i);
    }

    //Metodo que activa la pantalla AcercaDe
    public void lanzarAcercaDe() {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }


    //Metodo que activa la pantalla AcercaDe
    public void lanzarSalir() {
        finish();
    }
}
