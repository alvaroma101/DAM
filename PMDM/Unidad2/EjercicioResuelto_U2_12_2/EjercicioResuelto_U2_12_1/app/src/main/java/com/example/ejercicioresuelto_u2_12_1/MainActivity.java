package com.example.ejercicioresuelto_u2_12_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    AccesoDatos baseDatos;
    ArrayList<Contacto> contactos = new ArrayList<>();
    ArrayAdapter<Contacto> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseDatos = new AccesoDatos(this);

        lista = findViewById(R.id.listaContactos);
        //Obtenemos los contactos de la base de datos para crear el adaptador del listView
        baseDatos.obtenerContactos(contactos);
        adaptador = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,contactos);
        lista.setAdapter(adaptador);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.crearContacto:
                Intent crearContacto = new Intent(getApplicationContext(),CrearContacto.class);
                //Lanzamos la actividad y detectamos cuando finaliza
                startActivityForResult(crearContacto,1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            baseDatos.obtenerContactos(contactos);
            adaptador.notifyDataSetChanged();

        }
    }
}

