package com.example.mati.areastrazojerarquia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mati.myapplication.R;


public class main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonAreas = (Button) findViewById(R.id.buttonAreas);
        final Button buttonTrazo = (Button) findViewById(R.id.buttonTrazo);

        buttonAreas.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0)
            {
                Intent miIntent= new Intent(main.this, Areas.class);
                startActivity(miIntent);
            }
        });

        buttonTrazo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent miIntent = new Intent(main.this, Trazo.class);
                startActivity(miIntent);
            }
        });
    }

}
