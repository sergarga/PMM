package com.example.mati.solobici;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EjemploPreferencias extends Activity {
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;
    Context ctx = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplopreferencias);
        ctx = this;

        btnPreferencias = (Button)findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias = (Button)findViewById(R.id.BtnObtenerPreferencias);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EjemploPreferencias.this,
                        PantallaOpciones.class));
            }	});

        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences pref =
                        PreferenceManager.getDefaultSharedPreferences(
                                EjemploPreferencias.this);

                String s="Música = "+pref.getBoolean("opcion1", false)+
                         "\nTema = "+ pref.getString("opcion2", "")+
                         "\nNúmero de motos = "+pref.getString("opcion3", "")+
                         "\nMultijugador = "+pref.getBoolean("opcion4", false)+
                         "\nMax. Jugadores = "+ pref.getString("opcion5", "")+
                         "\nTipo de conexión = "+ pref.getString("opcion6", "");

                Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();

                /*Log.i("", "Opción 1: " + pref.getBoolean("opcion1", false));
                Log.i("", "Opción 2: " + pref.getString("opcion2", ""));
                Log.i("", "Opción 3: " + pref.getString("opcion3", ""));
                Log.i("", "Opción 4: " + pref.getBoolean("opcion4", false));
                Log.i("", "Opción 5: " + pref.getString("opcion5", ""));
                Log.i("", "Opción 6: " + pref.getString("opcion6", ""));*/
            } });
    }
}
