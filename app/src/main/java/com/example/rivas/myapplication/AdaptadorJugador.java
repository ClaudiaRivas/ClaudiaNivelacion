package com.example.rivas.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorJugador extends ArrayAdapter<Player> {

    public AdaptadorJugador(@NonNull Context context, List<Player> object) {
        super(context, 0 , object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Player jugador = getItem(position);
        if(convertView==null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_puntaje,parent,false);
        }

        TextView lblcontador = convertView.findViewById(R.id.lblContador);
        TextView textNombre = convertView.findViewById(R.id.textNombre);
        TextView textGanadas = convertView.findViewById(R.id.textGanadas);
        TextView textPerdidas = convertView.findViewById(R.id.textPerdidas);
        TextView textEmpate = convertView.findViewById(R.id.textEmpate);

        lblcontador.setText(String.valueOf(position+1));
        textNombre.setText(jugador.getNick());
        textGanadas.setText("Ganadas: "+String.valueOf(jugador.getGanadas()));
        textPerdidas.setText("Derrotas: "+String.valueOf(jugador.getPerdidas()));
        textEmpate.setText("Empates: "+String.valueOf(jugador.getEmpates()));

        return convertView;
    }
}
