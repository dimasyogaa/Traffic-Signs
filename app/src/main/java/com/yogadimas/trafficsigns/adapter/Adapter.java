package com.yogadimas.trafficsigns.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadimas.trafficsigns.R;
import com.yogadimas.trafficsigns.model.Signs;
import com.yogadimas.trafficsigns.view.MainActivity;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private final ArrayList<Signs> signsArrayList;

    public Adapter(ArrayList<Signs> signsArrayList) {
        this.signsArrayList = signsArrayList;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sign, parent, false);
        return new AdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {
        Signs signs = signsArrayList.get(position);
        holder.ivPhoto.setImageResource(signs.getPhoto());
        holder.tvDescription.setText(signs.getDescription());
    }

    @Override
    public int getItemCount() {
        return signsArrayList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivPhoto;
        private final TextView tvDescription;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.img_item_photo);
            tvDescription = itemView.findViewById(R.id.tv_item_description);

        }
    }
}
