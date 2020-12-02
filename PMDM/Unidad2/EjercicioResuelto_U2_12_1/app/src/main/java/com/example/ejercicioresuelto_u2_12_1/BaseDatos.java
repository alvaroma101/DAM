package com.example.ejercicioresuelto_u2_12_1;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.SQLException;

public class BaseDatos extends SQLiteOpenHelper {
    Context contexto;

    public BaseDatos(@Nullable Context context) {
        super(context, "Agenda", null, 1);
        contexto = context;
    }

    @Override
    //onCreate se ejecuta cuando se CREA la BD, solamente una vez para cada versión de la BD
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla
        try {
            //Creamos la tabla
            db.execSQL("CREATE TABLE contactos(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre VARCHAR, " +
                    "telefono VARCHAR, " +
                    "email VARCHAR)");
        }
        catch (Exception e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,"Error al crear la base da datos"+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    //onUpgrade se ejecuta cuando se ACTUALIZA la versíon de la BD
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            //Eliminamos la tabla anterior (si existe)
            db.execSQL("DROP TABLE IF EXISTS contactos");
            //Llamamos a onCreate para que cree la tabla con las nuevas especificaciones
            onCreate(db);
        }
        catch (Exception e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,"Error al actualziar la base de datos"+e,Toast.LENGTH_SHORT).show();
        }
    }
}
