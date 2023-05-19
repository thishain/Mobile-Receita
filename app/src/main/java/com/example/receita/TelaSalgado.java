package com.example.receita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TelaSalgado extends AppCompatActivity {

    ImageView ivTorta;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_salgado);
        setTitle("");


        toolbar = findViewById(R.id.meuMenu);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivTorta = (ImageView)findViewById(R.id.ivTodas);

        ivTorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListaReceitas = new Intent(getApplicationContext(), ListaReceitas.class);
                startActivity(ListaReceitas);


            }
        });
    }
}