package com.example.tarea21_mendez_alves_alvaro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    Spinner lugares;
    EditText precio, entradas, correo;
    Button ver_localizacion;
    RadioGroup radio_group;
    CheckBox check_correo;

    Integer[] precios = new Integer[] {35, 8, 2};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast toast;
        switch (item.getItemId()) {
            case R.id.reservar:
                Intent intent = new Intent(MainActivity.this, ResumenActivity.class);
                intent.putExtra("lugar", lugares.getSelectedItem().toString());
                intent.putExtra("precio", precio.getText().toString());
                intent.putExtra("entradas", entradas.getText().toString());
                intent.putExtra("turno", ((RadioButton)findViewById(radio_group.
                        getCheckedRadioButtonId())).getText().toString());
                MainActivity.this.startActivity(intent);
                return true;
            case R.id.cancelar:
                anularSelecciones();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lugares = findViewById(R.id.sp_lugar);
        precio = findViewById(R.id.edit_precio);
        ver_localizacion = findViewById(R.id.btn_localizacion);
        entradas = findViewById(R.id.edit_entradas);
        radio_group = findViewById(R.id.radio_group);
        check_correo = findViewById(R.id.check_correo);
        correo = findViewById(R.id.edit_correo);

        ArrayAdapter<CharSequence> adaptadorLugares = ArrayAdapter.createFromResource(getApplication(),
                R.array.lugares,android.R.layout.simple_spinner_item);
        lugares.setAdapter(adaptadorLugares);
        adaptadorLugares.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        lugares.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precio.setText(precios[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ver_localizacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String lugar = lugares.getSelectedItem().toString() + " Navalmoral de la Mata";
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, lugar);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);

                Toast toast = Toast.makeText(getApplicationContext(), checkedRadioButton.getText(),
                        100);
                toast.show();
            }
        });

        check_correo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    correo.setEnabled(true);
                } else {
                    correo.setEnabled(false);
                }
            }

        });

    }

    private void anularSelecciones() {
        lugares.setSelection(0);
        entradas.setText("");
        radio_group.check(R.id.radio_mañana);
        check_correo.setChecked(true);
        correo.setText("");
    }

}