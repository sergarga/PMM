package com.example.mati.examenpmm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mati.examenpmm.R;

public class dibujo extends Activity {

    float base, altura,radio, mitadH, mitadV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
        radio= 150;
        base = 500;
        altura = 600;
    }


    class MiDibujo extends View {

        public MiDibujo(Context c) {

            super(c);
        }

        protected void onDraw(Canvas lienzo) {

            lienzo.drawColor(Color.WHITE);
            Paint miPincel= new Paint();

            mitadH=lienzo.getWidth()/2;
            mitadV=lienzo.getHeight()/2;

            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setColor(Color.BLACK);
            miPincel.setStrokeWidth(5);

            //CABEZA
            lienzo.drawCircle(mitadH, mitadV/2, radio, miPincel);


            //VESTIDO
            miPincel.setColor(Color.MAGENTA);

            lienzo.drawLine(mitadH,
                    (mitadV/2)+radio,
                    mitadH+(base/2),
                    (mitadV/4)+radio+altura,
                    miPincel);

            lienzo.drawLine(mitadH+(base/2),
                    (mitadV/4)+radio+altura,
                    mitadH-(base/2),
                    (mitadV/4)+radio+altura,
                    miPincel);

            lienzo.drawLine(mitadH-(base/2),
                    (mitadV/4)+radio+altura,
                    mitadH,
                    (mitadV/2)+radio,
                    miPincel);


            miPincel.setColor(Color.GREEN);

            //PIERNA IZQUIERDA
            lienzo.drawLine(mitadH-(base/4),
                    (mitadV/4)+radio+altura+1,
                    mitadH-(base/4),
                    lienzo.getHeight()-200,
                    miPincel);
            //PIERNA DERECHA
            lienzo.drawLine(mitadH+(base/4),
                    (mitadV/4)+radio+altura+1,
                    mitadH+(base/4),
                    lienzo.getHeight()-200,
                    miPincel);

        }
    }
}
