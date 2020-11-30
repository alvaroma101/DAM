package com.example.tarea21_mendez_alves_alvaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        Intent intent = getIntent();
        String lugar = intent.getStringExtra("lugar");
        String precio = intent.getStringExtra("precio");
        String entradas = intent.getStringExtra("entradas");
        String turno = intent.getStringExtra("turno");

        TextView text_lugar = findViewById(R.id.text_lugar);
        TextView text_precio = findViewById(R.id.text_precio);
        TextView text_entradas = findViewById(R.id.text_entradas);
        TextView text_turno = findViewById(R.id.text_turno);

        text_lugar.setText("Lugar: "+lugar);
        text_precio.setText("Precio Entrada: "+precio);
        text_entradas.setText("Nº Entradas Reservadas: "+entradas);
        text_turno.setText("Turno: "+turno);
    }
}
