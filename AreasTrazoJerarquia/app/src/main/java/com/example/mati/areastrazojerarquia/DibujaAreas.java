package com.example.mati.areastrazojerarquia;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.Serializable;


public class DibujaAreas extends Activity {

    float radio, lado, ancho, alto, base, altura, area;
    String control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));

        Bundle  miBundleRecoger = getIntent().getExtras();

        control = miBundleRecoger.getString("Control");

        //RECOJO CIRCULO
        if(control.equals("circulo")){
            Circulo c = (Circulo) miBundleRecoger.getSerializable("circulo");
            radio = c.getRadio();
            area = c.area();

        }

        //RECOJO CUADRADO
        if(control.equals("cuadrado")){
            Cuadrado c = (Cuadrado) miBundleRecoger.getSerializable("cuadrado");
            lado = c.getLado();
            area = c.area();

        }

        //RECOJO RECTANGULO
        if(control.equals("rectangulo")){
            Rectangulo r = (Rectangulo) miBundleRecoger.getSerializable("rectangulo");
            ancho =  r.getBase();
            alto =  r.getAltura();
            area = r.area();

        }

        //RECOJO TRIANGULO
        if(control.equals("triangulo")) {
            Triangulo t = (Triangulo) miBundleRecoger.getSerializable("triangulo");
            base = t.getBase();
            altura = t.getAltura();
            area = t.area();
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
                lienzo.drawText("Area: "+area, 50, lienzo.getHeight()-50, miPincel);
            }

            if(control.equals("cuadrado")){
                lienzo.drawRect(((lienzo.getWidth()/2)-(lado/2)),
                        ((lienzo.getHeight()/2)-(lado/2)),
                        ((lienzo.getWidth()/2)+(lado/2)),
                        ((lienzo.getHeight()/2)+(lado/2)),
                        miPincel);
                lienzo.drawText("Area: "+area, 50, lienzo.getHeight()-50, miPincel);

            }

            if(control.equals("rectangulo")){
                lienzo.drawRect(((lienzo.getWidth()/2)-(ancho/2)),
                        ((lienzo.getHeight()/2)-(alto/2)),
                        ((lienzo.getWidth()/2)+(ancho/2)),
                        ((lienzo.getHeight()/2)+(alto/2)),
                        miPincel);
                lienzo.drawText("Area: "+area, 50, lienzo.getHeight()-50, miPincel);

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
                lienzo.drawText("Area: "+area, 50, lienzo.getHeight()-50, miPincel);

            }

        }
    }

}
