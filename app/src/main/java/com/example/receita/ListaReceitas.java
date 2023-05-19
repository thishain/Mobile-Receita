package com.example.receita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListaReceitas extends AppCompatActivity  {

    RecyclerView recyclerView;

    private Toolbar toolbar;
    MyDataBaseHelper myDB;
    ArrayList<String> rec_cod, rec_nome_receita, rec_autoria, mod_tempo_preparo;


    CustomAdapterListaReceitas customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salgados);
        setTitle("");

        toolbar = findViewById(R.id.meuMenu);
        recyclerView = findViewById(R.id.recyclerView_listaSalgados);


        //MENU APP
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDB = new MyDataBaseHelper(ListaReceitas.this, "receitas.db", 2);
        rec_cod = new ArrayList<>();
        rec_nome_receita = new ArrayList<>();
        rec_autoria = new ArrayList<>();
        mod_tempo_preparo = new ArrayList<>();

        mostrarReceitasSalgadas();
        customAdapter = new CustomAdapterListaReceitas(ListaReceitas.this, rec_cod, rec_nome_receita, rec_autoria, mod_tempo_preparo);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListaReceitas.this));

    }



    public void mostrarReceitasSalgadas() {
        Cursor cursor = myDB.listarSalgados();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "Não possui receitas!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                rec_cod.add(cursor.getString(0));
                rec_nome_receita.add(cursor.getString(1));
                rec_autoria.add(cursor.getString(2));
                mod_tempo_preparo.add(cursor.getString(3));
            }
        }

    }

}