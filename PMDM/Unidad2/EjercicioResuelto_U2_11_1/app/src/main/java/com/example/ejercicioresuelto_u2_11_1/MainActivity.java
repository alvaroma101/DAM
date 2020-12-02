package com.example.ejercicioresuelto_u2_11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    Button boton;
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contexto = this;

        texto = findViewById(R.id.texto);
        boton = findViewById(R.id.cambiar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDialogo();
            }
        });
    }
    private void abrirDialogo(){
        // Obtenemos el layout diaglo
        LayoutInflater li = LayoutInflater.from(contexto);
        View layoutCuadro = li.inflate(R.layout.dialogo, null);

        //Creamos un nuevo cuadro de diálogo
        AlertDialog.Builder cuadroDialogo = new AlertDialog.Builder(
                contexto);

        //Establecemos el layout del cuadro de diálogo
        cuadroDialogo.setView(layoutCuadro);

        //Creamos un elemento para acceder al campo editText del cuadro de diálogo
        final EditText nuevoTexto = (EditText) layoutCuadro.findViewById(R.id.nuevoTexto);

        //Programamos los botones del cuadro de diálogo
        cuadroDialogo
                .setCancelable(false)
                .setPositiveButton("Cambiar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //Modificamos el contenido de la etiqueta texto y le asignamos
                                //el contenido del nuevo texto que se ha escrito en el cuadro de diálogo
                                texto.setText(nuevoTexto.getText());
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        //Construimos el cuadro de diálogo y lo mostramos
        AlertDialog alertDialog = cuadroDialogo.create();
        cuadroDialogo.show();

    }
}