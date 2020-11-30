package com.example.ejercicioresuelto_u2_8_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listaPlanetas;
    Button ver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos con la interfaz
        listaPlanetas = findViewById(R.id.listaPlanetas);
        ver = findViewById(R.id.ver);
        //Creamos el adaptador del listView
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getApplicationContext(),R.array.planetas,android.R.layout.simple_list_item_multiple_choice);
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

    }
}