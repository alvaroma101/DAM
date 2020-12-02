package com.example.tarea21_mendez_alves_alvaro.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarea21_mendez_alves_alvaro.type.Producto;

import java.util.ArrayList;

public class BDAccesoDatos{
    private Context contexto;
    private BDListaCompra bdLista;
    private SQLiteDatabase bd;


    public BDAccesoDatos(Context c) {
        this.contexto = c;
        bdLista=new BDListaCompra(c);
    }

    //Método de inserción. Indicar el tipo de datos devuelto
    public long insertar(Producto producto){
        bd=bdLista.getWritableDatabase();

        //Insertar el código de inserción aquí
        ContentValues registro = new ContentValues();
        registro.put("producto", producto.getProducto());
        registro.put("cantidad", producto.getCantidad());
        registro.put("precio", producto.getPrecio());

        long resultado = bd.insert("compra",null,registro);

        //Fin código de inserción
        bd.close();

        //Añadir cláusula return
        return resultado;

    }

    //Método de consulta. Indicar el tipo de datos devuelto
    public void consultar(ArrayList<Producto> productos){
        bd=bdLista.getReadableDatabase();
        //Rellenar un ArrayList con el resultado de la consulta
        productos.clear();
        String[] columnas = {"id","producto","cantidad","precio"};

        Cursor cursor = bd.query("compra",columnas,null,null,null,null,null);
        //Recorremos cada registro que devuelve la consulta
        while(cursor.moveToNext()){
            //Creamos el contacto con los datos recuperados por la consulta
            Producto p = new Producto(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getFloat(3));
            productos.add(p);
        }

        //Fin código de consulta
        bd.close();
    }

    public long eliminar(int id){
        bd=bdLista.getWritableDatabase();
        //Insertar el código de eliminación aquí

        long resultado = bd.delete("compra","id="+id,null);

        //Fin código de consulta
        bd.close();

        return resultado;

    }
}