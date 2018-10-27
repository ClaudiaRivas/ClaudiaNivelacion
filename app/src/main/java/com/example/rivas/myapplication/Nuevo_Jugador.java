package com.example.rivas.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Nuevo_Jugador extends AppCompatActivity implements View.OnClickListener {

     private EditText edtextNick;
     private Button btnAceptar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo__jugador);
        edtextNick = (EditText ) findViewById(R.id.edtextNick);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAceptar:
                String Nombre=edtextNick.getText().toString();
                Intent resul = new Intent();
                resul.putExtra("Nombre",Nombre);
                setResult(MainActivity.JugadorN,resul);
                finish();
                break;
        }
    }
}
