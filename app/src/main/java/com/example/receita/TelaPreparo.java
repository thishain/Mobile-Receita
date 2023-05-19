package com.example.receita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaPreparo extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerViewIngredientes;
    private RecyclerView recyclerViewModoPreparo;

    CustomAdapterIngredientes customAdapterIngredientes;
    CustomAdapterModoPreparo customAdapterModoPreparo;

    MyDataBaseHelper myDB;
    TextView nome_receita_txt, nome_autor_txt, mod_tempo_preparo_txt;

    ArrayList<String> rec_nome_receita, rec_autoria, iten_ingredientes, mod_tempo_preparo, mod_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_preparo);
        setTitle("");

        toolbar = findViewById(R.id.meuMenu);
        nome_receita_txt = findViewById(R.id.rec_nome_receita_txt);
        nome_autor_txt = findViewById(R.id.rec_autoria_txt);
        mod_tempo_preparo_txt = findViewById(R.id.mod_tempo_preparo_txt);

        recyclerViewIngredientes = findViewById(R.id.recyclerView_ingredientes);
        recyclerViewModoPreparo = findViewById(R.id.recyclerView_modo_preparo);
        //MENU APP
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDB = new MyDataBaseHelper(TelaPreparo.this, "receitas.db", 2);
        mod_tempo_preparo = new ArrayList<>();
        rec_nome_receita = new ArrayList<>();
        rec_autoria = new ArrayList<>();
        iten_ingredientes = new ArrayList<>();
        mod_desc = new ArrayList<>();


        Intent it=getIntent();
        int pos = it.getIntExtra("cod_receita", 0);
        String nome_receita = it.getStringExtra("nome_receita");
        String nome_autor = it.getStringExtra("nome_autor");
        String tempo_preparo = it.getStringExtra("tempo_preparo");

        nome_receita_txt.setText(nome_receita);
        nome_autor_txt.setText(nome_autor);
        mod_tempo_preparo_txt.setText(tempo_preparo);

        mostrarIngredientes(pos);
        customAdapterIngredientes = new CustomAdapterIngredientes(TelaPreparo.this, iten_ingredientes);
        recyclerViewIngredientes.setAdapter(customAdapterIngredientes);
        recyclerViewIngredientes.setLayoutManager(new LinearLayoutManager(TelaPreparo.this));

        mostrarModoPreparo(pos);
        customAdapterModoPreparo = new CustomAdapterModoPreparo(TelaPreparo.this, mod_desc);
        recyclerViewModoPreparo.setAdapter(customAdapterModoPreparo);
        recyclerViewModoPreparo.setLayoutManager(new LinearLayoutManager(TelaPreparo.this));


    }

    void mostrarIngredientes(int codigo_receita) {
        Cursor cursor = myDB.listarIngredientes(codigo_receita);
            if(cursor.getCount() == 0) {
                Toast.makeText(this, "Não possui ingredientes!", Toast.LENGTH_SHORT).show();
            } else {
                while(cursor.moveToNext()) {
                     iten_ingredientes.add(cursor.getString(0));

                }
            }
    }

    void mostrarModoPreparo(int codigo_receita) {
        Cursor cursor = myDB.listarModoPreparo(codigo_receita);
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "Não possui preparos!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                mod_desc.add(cursor.getString(0));

            }
        }
    }



}