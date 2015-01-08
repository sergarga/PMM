package com.example.mati.ejemplobasedatos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.mati.ejemplobasedatos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class mostrar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar);

        final TextView lblNombre= (TextView)findViewById(R.id.LblNombre);
        final TextView lblApellido= (TextView)findViewById(R.id.LblTelefono);

        Bundle  miBundleRecoger = getIntent().getExtras();
        lblNombre.setText(lblNombre.getText()+" "+miBundleRecoger.getString("Nombre"));
        lblApellido.setText(lblApellido.getText()+" "+miBundleRecoger.getString("Apellido"));
    }

}
