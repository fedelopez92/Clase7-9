package com.example.alumno.clase7_9;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Persona> personas = new ArrayList<Persona>();
    private static final int PERMISO_REQUERIDO = 100;

    RecyclerView.Adapter adapter = new MyAdapter(personas, new OnItemClickListener() {
        @Override
        public void onClick(View v, int posicion) {

            //Log.d("Click item", "se hizo click en " + personas.get(posicion).getNombre() + " " + personas.get(posicion).getApellido());

            if(personas.get(posicion).getNombre().equals("Pablo") && personas.get(posicion).getApellido().equals("Speranza")){
                agregarPersona();
            }

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+personas.get(posicion).getNumero()));
            startActivity(intent);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {


            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_REQUERIDO);
            }
        }

        personas.add(new Persona("Fede", "Lopez", "4444444"));
        personas.add(new Persona("Matias", "Castaneda", "1111111"));
        personas.add(new Persona("Pablo", "Speranza", "2343212"));
        personas.add(new Persona("Elias", "Dufau", "4543344"));
        personas.add(new Persona("Matias", "Ramos", "5453454"));
        personas.add(new Persona("Javier", "Topalian", "4534534"));
        personas.add(new Persona("Selene", "Montano", "4545435"));
        personas.add(new Persona("Wendy", "Colace", "5534543"));

        RecyclerView rvPersonas = (RecyclerView) super.findViewById(R.id.recyclerView);

        rvPersonas.setAdapter(adapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        //hace el RecyclerView en forma lineal. Tambien esta el grid

        rvPersonas.setLayoutManager(layout);
    }

    /*public void clickEnElItem(int i){

        Log.d("Click item", "se hizo click en" + personas.get(i).getApellido());

        agregarPersona();
        adapter.notifyDataSetChanged();
    }*/

    public void agregarPersona(){

        personas.add(new Persona("Juan","Speranza", "3322423"));
        adapter.notifyDataSetChanged();
        //al agregar mas personas por ejemplo a traves de un metodo no se va a mostrar en el RecyclerView
        //con notifyDataSetChanged() se avisa al RecyclerView que cambio la informacion para que agregue en este caso a las personas
    }
}
