package com.example.receita;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterModoPreparo extends RecyclerView.Adapter<CustomAdapterModoPreparo.MyViewHolder>  {

    private Context context;
    private ArrayList mod_desc;

    public int positionBANCO;


    CustomAdapterModoPreparo(Context context,
                               ArrayList mod_desc) {
        this.context = context;
        this.mod_desc = mod_desc;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_modo_preparo, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mod_desc_txt.setText(String.valueOf(mod_desc.get(position)));
    }



    @Override
    public int getItemCount() {
        return mod_desc.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mod_desc_txt;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mod_desc_txt = itemView.findViewById(R.id.mod_desc_txt);
            cardView = itemView.findViewById(R.id.cardView);


        }

    }


}
