package com.example.ejercicioresuelto_u2_12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearContacto extends AppCompatActivity {
    EditText nombre, telefono, email;
    Button crear,cancelar;
    AccesoDatos baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contacto);

        nombre=findViewById(R.id.nombre);
        telefono=findViewById(R.id.telefono);
        email=findViewById(R.id.email);
        crear=findViewById(R.id.crear);
        cancelar=findViewById(R.id.cancelar);

        baseDatos = new AccesoDatos(this);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto = new Contacto(nombre.getText().toString(),telefono.getText().toString(),email.getText().toString());
                long id = baseDatos.insertar(contacto);
                if(id==-1){
                    Toast.makeText(getApplicationContext(),"Error al crear el contacto", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Se ha creado el registro con id "+id, Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}