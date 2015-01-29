package com.example.sergio.pruebasql;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class main extends Activity {

    private TextView userTextView, passTextView, errorTextView;
    private Button loginButton, regButton;
    String usuario, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userTextView = (TextView) this.findViewById(R.id.userTextView);
        this.passTextView = (TextView) this.findViewById(R.id.passTextView);
        this.errorTextView = (TextView) this.findViewById(R.id.errorTextView);
        this.loginButton = (Button) this.findViewById(R.id.loginButton);
        this.regButton = (Button) this.findViewById(R.id.regButton);



        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                errorTextView.setText("");
                usuario = "" + userTextView.getText();
                pass = "" + passTextView.getText();
                if (usuario.length() == 0 || pass.length() == 0) {
                    errorTextView.setText("Introduzca usuario y contraseña");
                } else {
                    new GetLoginTask().execute(new ApiConnector());
                    Toast.makeText(main.this, usuario + " " + pass, Toast.LENGTH_SHORT).show();
                }
            }
        });

        regButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(main.this, registro.class);
                startActivity(miIntent);
            }
        });


    }

    public void checkLogin(JSONArray jsonArray) {

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {

                json = jsonArray.getJSONObject(i);
                if((usuario.equals(json.getString("usuario")))&&(pass.equals(json.getString("password")))){
                    errorTextView.setText("Login correcto");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if(errorTextView.getText().equals("")){
            errorTextView.setText("Usuario o contraseña incorrectos");
        }

    }


    private class GetLoginTask extends AsyncTask<ApiConnector, Long, JSONArray> {

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            return params[0].GetLogin();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            checkLogin(jsonArray);
        }
    }
}
