package com.example.tarea21_mendez_alves_alvaro.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarea21_mendez_alves_alvaro.bbdd.BDAccesoDatos;
import com.example.tarea21_mendez_alves_alvaro.R;
import com.example.tarea21_mendez_alves_alvaro.type.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    BDAccesoDatos bdAccesoDatos;
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayAdapter<Producto> adaptador;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                abrirDialogo(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaCompra);

        bdAccesoDatos = new BDAccesoDatos(this);

        bdAccesoDatos.consultar(productos);
        adaptador = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,productos);
        lista.setAdapter(adaptador);
        ordenarLista();

        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(MainActivity.this, ResumeActivity.class);
                intent.putExtra("id", productos.get(position).getId());
                intent.putExtra("producto", productos.get(position).getProducto());
                intent.putExtra("cantidad", productos.get(position).getCantidad());
                intent.putExtra("precio", productos.get(position).getPrecio());
                startActivity(intent);
            }
        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Seguro que desea borrar el producto?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                long cant = bdAccesoDatos.eliminar(productos.get(pos).getId());
                                Toast toast;
                                if (cant == 1) {
                                    toast = Toast.makeText(getApplicationContext(), "El producto fue eliminado con exito", 2000);
                                } else {
                                    toast = Toast.makeText(getApplicationContext(), "Ha ocurrido un error, el producto no se pudo eliminar", 2000);
                                }
                                toast.show();
                                productos.remove(pos);
                                ordenarLista();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
                builder.show();
                return true;
            }
        });

    }

    private void abrirDialogo(Context context){
        LayoutInflater li = LayoutInflater.from(context);
        View layoutCuadro = li.inflate(R.layout.dialogo, null);

        AlertDialog.Builder cuadroDialogo = new AlertDialog.Builder(context);
        cuadroDialogo.setView(layoutCuadro);

        final EditText edit_producto = (EditText) layoutCuadro.findViewById(R.id.edit_producto);
        final EditText edit_cantidad = (EditText) layoutCuadro.findViewById(R.id.edit_cantidad);
        final EditText edit_precio = (EditText) layoutCuadro.findViewById(R.id.edit_precio);

        cuadroDialogo
                .setCancelable(false)
                .setPositiveButton("Añadir",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Producto producto = new Producto(edit_producto.getText().toString(),
                                        Integer.valueOf(edit_cantidad.getText().toString()),
                                        Float.parseFloat(edit_precio.getText().toString()));
                                long id_producto = bdAccesoDatos.insertar(producto);
                                Toast toast;
                                if (id_producto != -1) {
                                    toast = Toast.makeText(context,
                                            "Producto creado con exito, id: "+id_producto, 2000);
                                } else {
                                    toast = Toast.makeText(context,
                                            "Ha ocurrido un error, el producto no se pudo crear", 2000);
                                }
                                toast.show();
                                bdAccesoDatos.consultar(productos);
                                ordenarLista();
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = cuadroDialogo.create();
        cuadroDialogo.show();
    }

    public void ordenarLista() {

        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto producto1, Producto producto2) {
                return producto1.getProducto().compareToIgnoreCase(producto2.getProducto());
            }
        });
        adaptador.notifyDataSetChanged();
    }
}