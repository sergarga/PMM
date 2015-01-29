package com.example.mati.examenpmm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 29/01/15.
 */
public class ClientesSQLiteHelper extends SQLiteOpenHelper {

    String cadSQL = "CREATE TABLE Destinos (zona TEXT, tarifa TEXT, peso TEXT, decoracion TEXT, coste TEXT)";

    public ClientesSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        //Ejecutamos la sentencia SQL para crear la tabla Clientes
        //El metodo execSQL se limita a ejecutar directamente el codigo SQL que le pasemos.
        bd.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        //Eliminamos la version anterior de la tabla
        bd.execSQL("DROP TABLE IF EXISTS Destinos");

        //Creamos la nueva version de la tabla
        bd.execSQL(cadSQL);
    }

}

