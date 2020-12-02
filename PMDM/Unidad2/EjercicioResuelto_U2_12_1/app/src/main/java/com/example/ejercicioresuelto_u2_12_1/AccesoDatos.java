package com.example.ejercicioresuelto_u2_12_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class AccesoDatos {
    private Context contexto;
    BaseDatos miBD;

    public AccesoDatos(Context contexto) {
        this.contexto = contexto;
        miBD = new BaseDatos(contexto);
    }

    public long insertar(Contacto c){
        SQLiteDatabase accesoEscritura = miBD.getWritableDatabase();
        ////Hacer consulta inserción/modificación/borrado
        //Se crea un registro donde se especificará cada campo y su valor
        ContentValues registro = new ContentValues();
        registro.put("nombre", c.getNombre());
        registro.put("telefono",c.getTelefono());
        registro.put("email",c.getEmail());
        //Resultado permite comprobar si el insert se ha realizado o no
        long resultado = accesoEscritura.insert("contactos",null,registro);
        return resultado;
    }

}

