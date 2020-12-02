package com.example.ejercicioresuelto_u2_12_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        //Creamos un acceso para escritura
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

    public void obtenerContactos(ArrayList<Contacto> contactos) {
        //Creamos un acceso para lectura
        SQLiteDatabase accesoLectura = miBD.getReadableDatabase();
        //Limpiamos los contactos
        contactos.clear();
        //Definimos un array de string con las columnas a recuperar en el select
        String[] columnas = {"id","nombre","telefono","email"};
        //Ejecutamos la consulta. Indicamos la tabla y las columnas a recuperar. El resultado se almacena en un cursor.
        Cursor cursor = accesoLectura.query("contactos",columnas,null,null,null,null,null);
        //Recorremos cada registro que devuelve la consulta
        while(cursor.moveToNext()){
            //Creamos el contacto con los datos recuperados por la consulta
            Contacto c = new Contacto(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
            contactos.add(c);
        }

    }
}

