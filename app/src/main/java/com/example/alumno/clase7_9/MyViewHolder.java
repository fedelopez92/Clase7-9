package com.example.alumno.clase7_9;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 07/09/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public View v;
    public TextView tvnombre;
    public TextView tvapellido;
    public OnItemClickListener onItemClickListener;

    public MyViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        v = itemView;
        v.setOnClickListener(this);
        this.onItemClickListener = onItemClickListener;

        tvnombre = (TextView) v.findViewById(R.id.textView1);
        tvapellido = (TextView) v.findViewById((R.id.textView2));
    }

    @Override
    public void onClick(View v) {
        this.onItemClickListener.onClick(v, getAdapterPosition());
    }
}
