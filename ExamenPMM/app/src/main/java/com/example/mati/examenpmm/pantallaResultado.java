package com.example.mati.examenpmm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mati.examenpmm.R;

public class pantallaResultado extends Activity {

    String peso, tarifa, decoracion;
    double coste, costevariable;
    Destino destino;

    ImageView imagen;
    TextView zonaTxT, tarifaTxT, pesoTxT, decoracionTxT, costeTxT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultado);

        imagen = (ImageView) findViewById(R.id.imagen);

        zonaTxT = (TextView) findViewById(R.id.zonaTV);
        tarifaTxT = (TextView) findViewById(R.id.tarifaTV);
        pesoTxT = (TextView) findViewById(R.id.pesoTV);
        decoracionTxT = (TextView) findViewById(R.id.decoracionTV);
        costeTxT = (TextView) findViewById(R.id.costefinalTV);

        Bundle miBundleRecoger = getIntent().getExtras();

        destino = (Destino) miBundleRecoger.getSerializable("destino");
        tarifa = miBundleRecoger.getString("tarifa");
        decoracion = miBundleRecoger.getString("decoracion");
        peso = miBundleRecoger.getString("peso");

        if (destino.getZona().equals("Zona A")){
            imagen.setImageResource(R.drawable.asia_oceania);
        }

        if (destino.getZona().equals("Zona B")){
            imagen.setImageResource(R.drawable.america_africa);
        }

        if (destino.getZona().equals("Zona C")){
            imagen.setImageResource(R.drawable.europa);
        }

        zonaTxT.setText(zonaTxT.getText()+" "+destino.getZona());
        tarifaTxT.setText(tarifaTxT.getText()+" "+tarifa);
        pesoTxT.setText(pesoTxT.getText()+" "+peso+"Kg");
        decoracionTxT.setText(decoracionTxT.getText()+" "+decoracion);

        double pesocalc = Double.parseDouble(peso);

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

        costeTxT.setText(costeTxT.getText()+" "+coste);

        //DESGLOSE terminar
        //costeTxT.setText(costeTxT.getText()+" "+coste+ "("+destino.getPrecio()+"+("+costevariable+"*"+pesocalc+")");

    }


}
