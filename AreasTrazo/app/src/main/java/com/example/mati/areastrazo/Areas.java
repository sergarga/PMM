package com.example.mati.areastrazo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mati.areastrazo.R;

public class Areas extends Activity {

    public static int COD_RESPUESTA=0;
    final static String figuras[] = {"Elige una opcion..", "Circulo","Rectangulo","Triangulo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        final Spinner miSpinner = (Spinner) findViewById(R.id.spinner);

        final EditText primerTxt = (EditText) findViewById(R.id.primerTxt);
        final EditText segundoTxt = (EditText) findViewById(R.id.segundoTxt);

        final TextView primerTv = (TextView) findViewById(R.id.primerTv);
        final TextView segundoTv = (TextView) findViewById(R.id.segundoTv);

        final Button buttonAceptar = (Button) findViewById(R.id.buttonAceptar);



        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, figuras);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                primerTv.setVisibility(View.INVISIBLE);
                primerTxt.setVisibility(View.INVISIBLE);

                segundoTv.setVisibility(View.INVISIBLE);
                segundoTxt.setVisibility(View.INVISIBLE);

                buttonAceptar.setVisibility(View.INVISIBLE);


                switch (position){

                    case 1:
                        //CIRCULO
                        buttonAceptar.setVisibility(View.VISIBLE);
                        primerTv.setVisibility(View.VISIBLE);
                        primerTxt.setVisibility(View.VISIBLE);

                        primerTv.setText("Radio: ");
                        break;

                    case 2:
                        //RECTANGULO
                        buttonAceptar.setVisibility(View.VISIBLE);
                        primerTv.setVisibility(View.VISIBLE);
                        primerTxt.setVisibility(View.VISIBLE);

                        primerTv.setText("Alto: ");

                        segundoTv.setVisibility(View.VISIBLE);
                        segundoTxt.setVisibility(View.VISIBLE);

                        segundoTv.setText("Ancho: ");

                        break;

                    case 3:
                        //TRIANGULO
                        buttonAceptar.setVisibility(View.VISIBLE);
                        primerTv.setVisibility(View.VISIBLE);
                        primerTxt.setVisibility(View.VISIBLE);

                        primerTv.setText("Base: ");

                        segundoTv.setVisibility(View.VISIBLE);
                        segundoTxt.setVisibility(View.VISIBLE);

                        segundoTv.setText("Altura: ");
                        break;

                    default:

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonAceptar.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(Areas.this, DibujaAreas.class);
                Bundle miBundle=new Bundle();

                if(miSpinner.getSelectedItemPosition()==1) {
                    String control = "circulo";
                    String radio = "" + primerTxt.getText();
                    miBundle.putString("Control", control);
                    miBundle.putString("Radio", radio);
                }

                if(miSpinner.getSelectedItemPosition()==2) {
                    String control ="rectangulo";
                    String alto = "" + primerTxt.getText();
                    miBundle.putString("Control", control);
                    miBundle.putString("Alto", alto);

                    String ancho = "" + segundoTxt.getText();
                    miBundle.putString("Ancho", ancho);
                }

                if(miSpinner.getSelectedItemPosition()==3) {
                    String control= "triangulo";
                    miBundle.putString("Control", control);
                    String base = "" + primerTxt.getText();
                    miBundle.putString("Base", base);
                    String altura = "" + segundoTxt.getText();
                    miBundle.putString("Altura", altura);

                }

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);

            }

        });

    }
}
