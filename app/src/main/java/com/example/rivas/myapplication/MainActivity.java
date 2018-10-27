package com.example.rivas.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNuevo;
    private Button btnIniciar;
    private Button btnPuntajes;

    public static ArrayList<Player> listaJugadores;
    public static final int JugadorN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPuntajes = findViewById(R.id.btnPuntajes);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnNuevo = findViewById(R.id.btnNuevo);

        listaJugadores = new ArrayList<>();

        btnPuntajes.setOnClickListener(this);
        btnIniciar.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPuntajes:
                Intent lista = new Intent(getApplicationContext(), Puntajes.class);
                lista.putExtra("Listado", true);
                startActivity(lista);
                break;
            case R.id.btnIniciar:
                Intent list = new Intent(getApplicationContext(), Puntajes.class);
                startActivity(list);
                break;
            case R.id.btnNuevo:
                Intent nuevo = new Intent(getApplicationContext(), Nuevo_Jugador.class);
                startActivityForResult(nuevo, JugadorN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case JugadorN:
                if (data == null) return;
                String nombre = data.getExtras().getString("Nombre");
                Player play = new Player(listaJugadores.size() + 1, nombre, 0, 0, 0);
                listaJugadores.add(play);
                break;
        }
    }
}
