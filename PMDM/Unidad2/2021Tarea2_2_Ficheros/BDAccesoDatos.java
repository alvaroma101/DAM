package com.example.tarea2_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BDAccesoDatos{
    private Context contexto;
    private BDListaCompra bdLista;
    private SQLiteDatabase bd;


    public BDAccesoDatos(Context c) {
        this.contexto = c;
        bdLista=new BDListaCompra(c);
    }

    //Método de inserción. Indicar el tipo de datos devuelto
    public  insertar(){
        bd=bdLista.getWritableDatabase();
        //Insertar el código de inserción aquí



        //Fin código de inserción
        bd.close();

        //Añadir cláusula return


    }

    //Método de consulta. Indicar el tipo de datos devuelto
    public consultar(){
        bd=bdLista.getReadableDatabase();
        //Rellenar un ArrayList con el resultado de la consulta


        //Fin código de consulta
        bd.close();

    }

    public eliminar(){
        bd=bdLista.getWritableDatabase();
        //Insertar el código de eliminación aquí



        //Fin código de consulta
        bd.close();
        //Añadir cláusula return

    }
}