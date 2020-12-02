package com.example.tarea21_mendez_alves_alvaro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarea21_mendez_alves_alvaro.R;

public class ResumeActivity extends AppCompatActivity {

    EditText edit_id, edit_producto, edit_cantidad, edit_precio;
    Button btn_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("id", 0);
        String producto = intent.getStringExtra("producto");
        Integer cantidad = intent.getIntExtra("cantidad", 0);
        Float precio = intent.getFloatExtra("precio", (float) 0.0);

        edit_id = findViewById(R.id.edit_id);
        edit_producto = findViewById(R.id.edit_producto);
        edit_cantidad = findViewById(R.id.edit_cantidad);
        edit_precio = findViewById(R.id.edit_precio);
        btn_atras = findViewById(R.id.atras);

        edit_id.setText(id.toString());
        edit_producto.setText(producto);
        edit_cantidad.setText(cantidad.toString());
        edit_precio.setText(precio.toString());

        btn_atras.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}