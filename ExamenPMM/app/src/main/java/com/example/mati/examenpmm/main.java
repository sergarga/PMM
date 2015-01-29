package com.example.mati.examenpmm;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class main extends Activity {

    public static int COD_RESPUESTA=0;

    SQLiteDatabase db;

    ArrayList<Destino> destinos = new ArrayList<Destino>();
    Destino destino;

    double coste, costevariable;

    Spinner miSpinner;
    RadioGroup rg;
    CheckBox regalo, tarjeta;
    EditText peso;
    Button calculo;

    String tarifa, zona, decoracion="", pesotxt, costefinal;

    static class ViewHolder{
        TextView zona;
        TextView continente;
        TextView precio;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.miSpinner);

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        regalo = (CheckBox) findViewById(R.id.checkRegalo);
        tarjeta = (CheckBox) findViewById(R.id.checkTarjeta);

        peso = (EditText) findViewById(R.id.pesoTxt);

        calculo = (Button) findViewById(R.id.botonCalculos);


        destinos.add(new Destino("Zona A", "Asia y Oceania", 30));
        destinos.add(new Destino("Zona B", "America y Africa", 20));
        destinos.add(new Destino("Zona C", "Europa", 10));

        AdaptadorCliente miAdaptador = new AdaptadorCliente(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                destino = (Destino)arg0.getItemAtPosition(position);
                //Toast.makeText(main.this, cliente.getNombre(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( group.getCheckedRadioButtonId()==R.id.radioNormal)
                    tarifa ="Normal";
                if( group.getCheckedRadioButtonId()==R.id.radioUrgente)
                    tarifa ="Urgente";
            }
        });

        calculo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(regalo.isChecked() && tarjeta.isChecked()){
                    decoracion = "Con regalo y tarjeta dedicatoria";
                } else if (!regalo.isChecked() && !tarjeta.isChecked()){
                    decoracion = "Ninguna";
                } else if (regalo.isChecked()){
                    decoracion ="Con regalo";
                } else if(tarjeta.isChecked()){
                    decoracion = "Con tarjeta";
                }
                pesotxt = peso.getText().toString();

                //PASO PARAMETROS A SEGUNDA PANTALLA

                Intent miIntent= new Intent(main.this, pantallaResultado.class);
                Bundle miBundle=new Bundle();

                miBundle.putString("tarifa",tarifa);
                miBundle.putString("decoracion", decoracion);
                miBundle.putString("peso", pesotxt);
                miBundle.putSerializable("destino", destino);

                //Toast.makeText(main.this, tarifa+"\n"+decoracion+"\n"+pesotxt, Toast.LENGTH_SHORT).show();

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);


            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:

                if(regalo.isChecked() && tarjeta.isChecked()){
                    decoracion = "Con regalo y tarjeta dedicatoria";
                } else if (!regalo.isChecked() && !tarjeta.isChecked()){
                    decoracion = "Ninguna";
                } else if (regalo.isChecked()){
                    decoracion ="Con regalo";
                } else if(tarjeta.isChecked()){
                    decoracion = "Con tarjeta";
                }

                pesotxt = peso.getText().toString();

                //CALCULO COSTE FINAL


                double pesocalc = Double.parseDouble(pesotxt);

                if(pesocalc <= 5){
                    costevariable = 1;
                }else if (pesocalc > 5 && pesocalc <=10){
                    costevariable = 1.5;
                }else if (pesocalc >10){
                    costevariable = 2;
                }

                coste = destino.getPrecio()+(costevariable*pesocalc);

                if(tarifa.equals("Urgente")){
                    coste = coste + coste * 0.3;
                }

                costefinal = coste+"";


                //INSERTO EN BD

                ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(main.this, "DBdestinos", null, 1);
                db = cliBDh.getWritableDatabase();

                //En caso de abrir de forma correcta la base de datos
                if (db != null) {

                    db.execSQL("INSERT INTO Destinos ( zona, tarifa, peso, decoracion, coste) " +
                            "VALUES ('" + destino.getZona() + "', '" + tarifa + "', '" + pesotxt + "', '" + decoracion + "','"+coste+"')");

                    db.close();
                }

                Toast.makeText(main.this, "Insertado en BD", Toast.LENGTH_SHORT).show();

                Intent miIntent= new Intent(main.this, pantallaResultado.class);
                Bundle miBundle=new Bundle();

                miBundle.putString("tarifa",tarifa);
                miBundle.putString("decoracion", decoracion);
                miBundle.putString("peso", pesotxt);
                miBundle.putSerializable("destino", destino);

                //Toast.makeText(main.this, tarifa+"\n"+decoracion+"\n"+pesotxt, Toast.LENGTH_SHORT).show();

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
                return true;

            case R.id.MnuOpc2:

                Intent miIntentdi= new Intent(main.this, dibujo.class);
                startActivity(miIntentdi);
                return true;

            case R.id.MnuOpc3:
                leerRegistros();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    class AdaptadorCliente extends ArrayAdapter{

        Activity context;
        @SuppressWarnings("unchecked")
        public AdaptadorCliente(Activity context) {
            super(context, R.layout.downspiner,destinos);
            this.context=context;

        }

        public View getDropDownView(int posicion,View convertView,ViewGroup parent){
            return getView(posicion,convertView,parent);
        }

        public View getView(int posicion,View convertView,ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if(item==null){
                LayoutInflater inflater=context.getLayoutInflater();
                item=inflater.inflate(R.layout.downspiner,null);

                holder=new ViewHolder();
                holder.zona=(TextView)item.findViewById(R.id.zona);
                holder.continente=(TextView)item.findViewById(R.id.continente);
                holder.precio=(TextView)item.findViewById(R.id.precio);


                item.setTag(holder);

            }
            else
                holder=(ViewHolder)item.getTag();

            holder.zona.setText(destinos.get(posicion).getZona());
            holder.continente.setText(destinos.get(posicion).getContinente());
            holder.precio.setText(destinos.get(posicion).getPrecio()+"");


            return item;
        }

    }

    public void leerRegistros(){
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(main.this, "DBdestinos", null, 1);
        db = cliBDh.getWritableDatabase();

        String[] campos = new String[] {"zona", "tarifa", "peso", "decoracion", "coste"};

        Cursor c = db.query("Destinos", campos, null, null, null, null, null);
        int i=0;
        if (c.moveToFirst()) {

            do {
                String zonaDes = c.getString(0);
                String tarifaDes = c.getString(1);
                String pesoDes = c.getString(2);
                String decoracionDes = c.getString(3);
                String costeDes = c.getString(4);

                String tostring = "Registro " + i +"\n"+ zonaDes +"\n"+ tarifaDes +"\n"+ pesoDes +"\n"+ decoracionDes+"\n"+costeDes;

                Toast.makeText(main.this, tostring, Toast.LENGTH_SHORT).show();
                i++;

            } while (c.moveToNext());
        }

        db.close();

    }



}
