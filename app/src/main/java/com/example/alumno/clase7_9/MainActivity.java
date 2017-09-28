package com.example.alumno.clase7_9;

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

    RecyclerView.Adapter adapter = new MyAdapter(personas, new OnItemClickListener() {

        @Override
        public void onClick(View v, int posicion) {

            Log.d("Click item", "se hizo click en " + personas.get(posicion).getNombre() + " " + personas.get(posicion).getApellido());

            if(personas.get(posicion).getNombre().equals("Pablo") && personas.get(posicion).getApellido().equals("Speranza")){
                agregarPersona();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas.add(new Persona("Fede", "Lopez"));
        personas.add(new Persona("Matias", "Castaneda"));
        personas.add(new Persona("Pablo", "Speranza"));
        personas.add(new Persona("Elias", "Dufau"));
        personas.add(new Persona("Matias", "Ramos"));
        personas.add(new Persona("Javier", "Topalian"));
        personas.add(new Persona("Selene", "Montano"));
        personas.add(new Persona("Wendy", "Colace"));

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

        personas.add(new Persona("Juan", "Speranza"));
        adapter.notifyDataSetChanged();
        //al agregar mas personas por ejemplo a traves de un metodo no se va a mostrar en el RecyclerView
        //con notifyDataSetChanged() se avisa al RecyclerView que cambio la informacion para que agregue en este caso a las personas
    }
}
