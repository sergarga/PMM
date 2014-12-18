package com.example.mati.areastrazo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mati.areastrazo.R;

public class DibujaAreas extends Activity {

    float radio, ancho, alto, base, altura;
    String control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));

        Bundle  miBundleRecoger = getIntent().getExtras();

        control = miBundleRecoger.getString("Control");

        if(control.equals("circulo")){
            radio = Float.parseFloat(miBundleRecoger.getString("Radio"));
        }

        if(control.equals("rectangulo")){
            alto = Float.parseFloat(miBundleRecoger.getString("Alto"));
            ancho = Float.parseFloat(miBundleRecoger.getString("Ancho"));

        }

        if(control.equals("triangulo")) {
            base = Float.parseFloat(miBundleRecoger.getString("Base"));
            altura = Float.parseFloat(miBundleRecoger.getString("Altura"));
        }

    }

    class MiDibujo extends View {

        public MiDibujo(Context c) {

            super(c);
        }

        protected void onDraw(Canvas lienzo){

            lienzo.drawColor(Color.WHITE);
            Paint miPincel= new Paint();

            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setColor(Color.BLACK);
            miPincel.setStrokeWidth(5);
            miPincel.setTextSize(80);

            if(control.equals("circulo")){
                lienzo.drawCircle(lienzo.getWidth() / 2, lienzo.getHeight() / 2, radio, miPincel);
                lienzo.drawText("Area: "+String.valueOf((radio*radio*Math.PI)), 50, lienzo.getHeight()-50, miPincel);
            }

            if(control.equals("rectangulo")){
                lienzo.drawRect(((lienzo.getWidth()/2)-(ancho/2)),
                                ((lienzo.getHeight()/2)-(alto/2)),
                                ((lienzo.getWidth()/2)+(ancho/2)),
                                ((lienzo.getHeight()/2)+(alto/2)),
                                miPincel);
                lienzo.drawText("Area: "+String.valueOf((ancho*alto)), 50, lienzo.getHeight()-50, miPincel);

            }

            if(control.equals("triangulo")) {
                lienzo.drawLine((lienzo.getWidth()/2)-(base/2),
                                 lienzo.getHeight()/2+(altura/2),
                                 lienzo.getWidth()/2,
                                 lienzo.getHeight()/2-(altura/2),
                                 miPincel);

                lienzo.drawLine(lienzo.getWidth()/2,
                                lienzo.getHeight()/2-(altura/2),
                               (lienzo.getWidth()/2)+(base/2),
                                lienzo.getHeight()/2+(altura/2),
                                miPincel);

                lienzo.drawLine((lienzo.getWidth()/2)+(base/2),
                                 lienzo.getHeight()/2+(altura/2),
                                (lienzo.getWidth()/2)-(base/2),
                                 lienzo.getHeight()/2+(altura/2),
                                 miPincel);
                lienzo.drawText("Area: "+String.valueOf((base*altura)/2), 50, lienzo.getHeight()-50, miPincel);

            }

        }
    }

}
