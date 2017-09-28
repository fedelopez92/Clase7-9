package com.example.alumno.clase7_9;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alumno on 07/09/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Persona> personas;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<Persona> personas, OnItemClickListener onItemClickListener){

        this.personas = personas;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v, onItemClickListener);//ViewHolder tranfiere informacion entre el adapter y el RecyclerView
        //inflate convierte un xml de layout en una view
        return myViewHolder;
    }//crea los rectangulos de RecyclerView
    //Solo va a crear la cantidad que entren en pantalla
    //a medida que vamos scrolleando solo se cambia la informacion. Los rectangulos del RecyclerView son siempre los mismos

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { //carga con informacion el RecyclerView
        Persona p = personas.get(position);
        String nombre = p.getNombre();
        String apellido = p.getApellido();
        holder.tvnombre.setText(nombre);
        holder.tvapellido.setText(apellido);
    }

    @Override
    public int getItemCount() {
        return personas.size();//si no le ponemos la cantidad de la lista el RecyclerView no muestra nada
    }

}
