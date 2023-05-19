package com.example.receita;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterListaReceitas extends RecyclerView.Adapter<CustomAdapterListaReceitas.MyViewHolder>  {

    private Context context;
    private ArrayList rec_cod, rec_nome_receita, rec_autoria, mod_tempo_preparo;

    public int positionBANCO;



    CustomAdapterListaReceitas(Context context,
                               ArrayList rec_cod,
                               ArrayList rec_nome_receita,
                               ArrayList rec_autoria,
                               ArrayList mod_tempo_preparo) {
        this.context = context;
        this.rec_cod = rec_cod;
        this.rec_nome_receita = rec_nome_receita;
        this.rec_autoria = rec_autoria;
        this.mod_tempo_preparo = mod_tempo_preparo;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_receitas, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.rec_cod_txt.setText(String.valueOf(rec_cod.get(position)));
        holder.rec_nome_receita_txt.setText(String.valueOf(rec_nome_receita.get(position)));
        holder.rec_autoria_txt.setText(String.valueOf(rec_autoria.get(position)));
        holder.mod_tempo_preparo_txt.setText(String.valueOf(mod_tempo_preparo.get(position)));


        holder.itemView.setOnClickListener(view -> {
            Intent TelaPreparo = new Intent(context,TelaPreparo.class);
            TelaPreparo.putExtra("nome_receita", String.valueOf(rec_nome_receita.get(position)));
            TelaPreparo.putExtra("nome_autor", String.valueOf(rec_autoria.get(position)));
            TelaPreparo.putExtra("tempo_preparo", String.valueOf(mod_tempo_preparo.get(position)));
            TelaPreparo.putExtra("cod_receita", position+1);
            context.startActivity(TelaPreparo);

        });

    }


    @Override
    public int getItemCount() {
        return rec_cod.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rec_cod_txt, rec_nome_receita_txt, rec_autoria_txt, mod_tempo_preparo_txt;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_cod_txt = itemView.findViewById(R.id.rec_cod_txt);
            rec_nome_receita_txt = itemView.findViewById(R.id.rec_nome_receita_txt);
            rec_autoria_txt = itemView.findViewById(R.id.rec_autoria_txt);
            mod_tempo_preparo_txt = itemView.findViewById(R.id.mod_tempo_preparo_txt);
            cardView = itemView.findViewById(R.id.cardView);


        }

    }


}
