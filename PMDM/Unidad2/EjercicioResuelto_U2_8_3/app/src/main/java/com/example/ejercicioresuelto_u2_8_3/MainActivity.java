package com.example.ejercicioresuelto_u2_8_3;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listaPlanetas;
    Button ver;

    //Declaramos el adpatador fuera del método onCreate para tener acceso a él en los listeners
    ArrayAdapter<String> adaptador;
    //Declaramos el ArrayList que será origen del adaptador
    ArrayList<String> planetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos con la interfaz
        listaPlanetas = findViewById(R.id.listaPlanetas);
        ver = findViewById(R.id.ver);
        //Creamos el adaptador del listView cuyo origen de datos va a ser un ArrayList
        //Rellenamos el arraylist con los planetas definido en el fichero de recursos;
        planetas = new ArrayList<>(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.planetas))));

        adaptador = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_multiple_choice,planetas);
        listaPlanetas.setAdapter(adaptador);

        //Capturamos el evento de selección de un elemento de la lista
        listaPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(),"Se ha seleccionado "+parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selección = "";
                SparseBooleanArray posSeleccionada = listaPlanetas.getCheckedItemPositions();
                for(int i=0;i<posSeleccionada.size();i++){
                    int posicionAdaptador = posSeleccionada.keyAt(i);
                    if(posSeleccionada.get(posicionAdaptador)){
                        selección += listaPlanetas.getItemAtPosition(posicionAdaptador)+" ";
                    }
                }
                Toast.makeText(getApplicationContext(),"Se han seleccionado "+selección,Toast.LENGTH_LONG).show();
            }
        });
        //Capturar el evento de pulsación larga sobre la lista
        listaPlanetas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Borramos el item seleccionado del ArrayList
                planetas.remove(parent.getItemAtPosition(position));
                //Comunicamos al adaptador que el origen de datos ha cambiado
                adaptador.notifyDataSetChanged();
                return true;
            }
        });

    }



}