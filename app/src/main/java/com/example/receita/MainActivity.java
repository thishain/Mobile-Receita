package com.example.receita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    ImageView btnDoce, btnSalgado;
    MyDataBaseHelper dataBaseHelper;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //MENU APP
        toolbar = findViewById(R.id.meuMenu);
        setSupportActionBar(toolbar);
        setTitle("");

        //COPIANDO BANCO DE DADOS
        dataBaseHelper = new MyDataBaseHelper(this, "receitas.db", 1);

        try {
            dataBaseHelper.CheckDb();
        } catch (Exception e) {e.printStackTrace();}
        try {
            dataBaseHelper.OpenDataBase();
        } catch (Exception e) {e.printStackTrace();}


        btnDoce = (ImageView) findViewById(R.id.btnDoce);
        btnSalgado = (ImageView) findViewById(R.id.btnSalgado);

        btnDoce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent TelaDoce = new Intent(getApplicationContext(),TelaDoce.class);
                startActivity(TelaDoce);
                //Toast.makeText(MainActivity.this, "Você clicou no botao doce!!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSalgado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TelaSalgado = new Intent(getApplicationContext(),TelaSalgado.class);
                startActivity(TelaSalgado);
                //Toast.makeText(MainActivity.this, "Você clicou no botao salgado!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}