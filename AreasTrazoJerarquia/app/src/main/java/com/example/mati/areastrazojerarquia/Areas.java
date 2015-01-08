package com.example.mati.areastrazojerarquia;

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

import com.example.mati.myapplication.R;


public class Areas extends Activity {

    public static int COD_RESPUESTA=0;
    final static String figuras[] = {"Elige una opcion..", "Circulo","Cuadrado","Rectangulo","Triangulo"};


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

                        //CUADRADO
                        buttonAceptar.setVisibility(View.VISIBLE);
                        primerTv.setVisibility(View.VISIBLE);
                        primerTxt.setVisibility(View.VISIBLE);

                        primerTv.setText("Lado: ");
                        break;

                    case 3:
                        //RECTANGULO
                        buttonAceptar.setVisibility(View.VISIBLE);
                        primerTv.setVisibility(View.VISIBLE);
                        primerTxt.setVisibility(View.VISIBLE);

                        primerTv.setText("Alto: ");

                        segundoTv.setVisibility(View.VISIBLE);
                        segundoTxt.setVisibility(View.VISIBLE);

                        segundoTv.setText("Ancho: ");

                        break;

                    case 4:
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

                    String radio = "" + primerTxt.getText();
                    float r = Float.parseFloat(radio);
                    Circulo c = new Circulo(r);
                    String control = c.getTipo();
                    miBundle.putSerializable("circulo", c);
                    miBundle.putString("Control", control);

                }

                if(miSpinner.getSelectedItemPosition()==2) {

                    String lado = "" + primerTxt.getText();
                    float l = Float.parseFloat(lado);
                    Cuadrado c = new Cuadrado(l);
                    String control = c.getTipo();
                    miBundle.putString("Control", control);
                    miBundle.putSerializable("cuadrado", c);

                }

                if(miSpinner.getSelectedItemPosition()==3) {

                    String alto = "" + primerTxt.getText();
                    float a = Float.parseFloat(alto);

                    String ancho = "" + segundoTxt.getText();
                    float an = Float.parseFloat(ancho);

                    Rectangulo r = new Rectangulo(a, an);

                    String control = r.getTipo();
                    miBundle.putString("Control", control);

                    miBundle.putSerializable("rectangulo", r);
                }

                if(miSpinner.getSelectedItemPosition()==4) {



                    String base = "" + primerTxt.getText();
                    float b = Float.parseFloat(base);

                    String altura = "" + segundoTxt.getText();
                    float a = Float.parseFloat(altura);

                    Triangulo t = new Triangulo (a, b);

                    String control= t.getTipo();

                    miBundle.putString("Control", control);
                    miBundle.putSerializable("triangulo", t);


                }

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);

            }

        });

    }
}
