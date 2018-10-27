package com.example.rivas.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Random;

public class Iniciar_Juego extends AppCompatActivity implements View.OnClickListener {

    private Button btnTijera;
    private Button btnPiedra;
    private Button btnPapel;
    private Button btnCpU;
    private Button btnFinalizar;
    private TextView textCPU;
    private TextView textGanados;
    private TextView textPerdidos;
    private TextView textEmpatados;
    private TextView textPlayer;
    private TextView textMarcador;

    public final int Piedra=1;
    public final int Papel=2;
    public final int Tijera=3;
    public static Player playe;
    public static int posicion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar__juego);

        btnTijera = findViewById(R.id.btnTijera);
        btnPiedra = findViewById(R.id.btnPiedra);
        btnPapel =  findViewById(R.id.btnPapel);
        btnCpU = findViewById(R.id.btnCpU);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        textCPU = (TextView) findViewById(R.id.textCPU);
        textGanados = (TextView) findViewById(R.id.textGanados);
        textPerdidos = (TextView) findViewById(R.id.textPerdidos);
        textEmpatados = (TextView) findViewById(R.id.textEmpatados);
        textPlayer = (TextView) findViewById(R.id.textPlayer);
        textMarcador = (TextView) findViewById(R.id.textMarcador);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        posicion=getIntent().getIntExtra("Posicion", 0);

        playe=MainActivity.listaJugadores.get(posicion);

        textPlayer.setText(playe.getNick());
        textMarcador.setText("0");
        textGanados.setText("Ganados: "+String.valueOf(playe.getGanadas()));
        textPerdidos.setText("Perdidos: "+String.valueOf(playe.getPerdidas()));
        textEmpatados.setText("Empatados: "+String.valueOf(playe.getEmpates()));

        btnTijera.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnPiedra.setOnClickListener(this);
        btnFinalizar.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.listaJugadores.set(posicion, playe);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnPapel:
                Evaluacion(Papel);
                break;
            case R.id.btnTijera:
                Evaluacion(Tijera);
                break;
            case R.id.btnPiedra:
                Evaluacion(Piedra);
                break;
            case R.id.btnFinalizar:
                finish();
                break;
        }
    }

    private void Evaluacion(int Jug){
        Random r = new Random();
        int i = r.nextInt(4 - 1) + 1;
        int puntos=Integer.parseInt(textMarcador.getText().toString());
        switch(i){
            case 1: {
                btnCpU.setText("O");
                if (Jug == Piedra) {
                    playe.setEmpates(playe.getEmpates() + 1);
                    textEmpatados.setText("Empatados: "+String.valueOf(playe.getEmpates()));
                } else {
                    if (Jug == Papel) {
                        playe.setGanadas(playe.getGanadas() + 1);
                        puntos+=6;
                        textMarcador.setText(String.valueOf(puntos));
                        textGanados.setText("Ganados: "+String.valueOf(playe.getGanadas()));
                    } else {
                        puntos-=3;
                        textMarcador.setText(String.valueOf(puntos));
                        playe.setPerdidas(playe.getPerdidas() + 1);
                        textPerdidos.setText("Perdidos: "+String.valueOf(playe.getPerdidas()));
                    }
                }
            }
            break;
            case 2:
            {
                btnCpU.setText("[_]");
                if (Jug == Piedra) {
                    puntos-=3;
                    textMarcador.setText(String.valueOf(puntos));
                    playe.setPerdidas(playe.getPerdidas() + 1);
                    textPerdidos.setText("Perdidos: "+String.valueOf(playe.getPerdidas()));
                } else {
                    if (Jug == Papel) {
                        playe.setEmpates(playe.getEmpates() + 1);
                        textEmpatados.setText("Empatados: "+String.valueOf(playe.getEmpates()));
                    } else {
                        puntos+=6;
                        textMarcador.setText(String.valueOf(puntos));
                        playe.setGanadas(playe.getGanadas() + 1);
                        textGanados.setText("Ganados: "+String.valueOf(playe.getGanadas()));
                    }
                }
            }
            break;
            case 3:
            {
                btnCpU.setText("X");
                if (Jug == Piedra) {
                    puntos+=6;
                    textMarcador.setText(String.valueOf(puntos));
                    playe.setGanadas(playe.getGanadas() + 1);
                    textGanados.setText("Ganados: "+String.valueOf(playe.getGanadas()));

                } else {
                    if (Jug == Papel) {
                        puntos-=3;
                        textMarcador.setText(String.valueOf(puntos));
                        playe.setPerdidas(playe.getPerdidas() + 1);
                        textPerdidos.setText("Perdidos: "+String.valueOf(playe.getPerdidas()));
                    } else {
                        playe.setEmpates(playe.getEmpates() + 1);
                        textEmpatados.setText("Empatados: "+String.valueOf(playe.getEmpates()));
                    }
                }
            }

            break;
        }

    }
}
