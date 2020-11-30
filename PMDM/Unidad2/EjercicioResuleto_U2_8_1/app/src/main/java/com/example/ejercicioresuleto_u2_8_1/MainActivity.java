package com.example.ejercicioresuleto_u2_8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Objetos a enlazar con los elementos de la interfaz
    Spinner dias, meses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dias = findViewById(R.id.dias);
        meses = findViewById(R.id.meses);

        //SPNINNER DÍAS
        //Creamos el adaptador de los días con los datos del array definido en un fichero de recursos
        ArrayAdapter<CharSequence> adaptadorDias = ArrayAdapter.createFromResource(getApplication(),R.array.dias,android.R.layout.simple_spinner_item);
        //Establecemos el adaptador del spinner dias
        dias.setAdapter(adaptadorDias);
        adaptadorDias.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        //Capturar el evento setOnItemSelectedListener para mostrar un mensaje con el día seleccionado
        dias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Has seleccionado "+parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //SPINNER MESES
        //Creamos el ArrayList con los meses del año
        ArrayList<String> arrayMeses = new ArrayList<>();
        arrayMeses.add("Enero");arrayMeses.add("Febrero");arrayMeses.add("Marzo");arrayMeses.add("Abril");
        arrayMeses.add("Mayo");arrayMeses.add("Junio");arrayMeses.add("Julio");arrayMeses.add("Agosto");
        arrayMeses.add("Septiembre");arrayMeses.add("Octubre");arrayMeses.add("Noviembre");arrayMeses.add("Diciembre");
        //Creamos el adaptador de los días con los datos del array definido en un fichero de recursos
        ArrayAdapter<String> adaptadorMeses = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayMeses);
        //Establecemos el adaptador del spinner dias
        meses.setAdapter(adaptadorMeses);
        //Capturar el evento setOnItemSelectedListener para mostrar un mensaje con el día seleccionado
        meses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Has seleccionado "+parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}