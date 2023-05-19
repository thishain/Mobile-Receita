package com.example.receita;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterIngredientes extends RecyclerView.Adapter<CustomAdapterIngredientes.MyViewHolder> {

    private Context context;
    private ArrayList iten_ingredientes;
    int num_receita =0;

    CustomAdapterIngredientes(Context context,
                              ArrayList iten_nome_ingrediente
                             ) {
        this.context = context;
        this.iten_ingredientes = iten_nome_ingrediente;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_ingredientes, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iten_ingredientes_txt.setText(String.valueOf(iten_ingredientes.get(position)));
    }


    @Override
    public int getItemCount() {
        return iten_ingredientes.size();
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView iten_ingredientes_txt;
        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iten_ingredientes_txt = itemView.findViewById(R.id.iten_ingredientes_txt);
            cardView = itemView.findViewById(R.id.cardView);

            iten_ingredientes_txt.setText("XD - ");



        }
    }


}
