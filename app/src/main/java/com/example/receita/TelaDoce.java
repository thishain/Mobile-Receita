package com.example.receita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaDoce extends AppCompatActivity {

    ImageView btnVolta;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_doce);
        setTitle("");

        toolbar = findViewById(R.id.meuMenu);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("");

        btnVolta = (ImageView)findViewById(R.id.btnVolta);

        btnVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(TelaDoce.this, "Você clicou no botao doce!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}