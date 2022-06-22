package com.example.lesson3.network.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lesson3.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    ArrayList<Hit> list;

    public ImageAdapter(ArrayList<Hit> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;

        public ViewHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
        public void onBind(Hit model){
            Glide.with(itemBinding.imgImage).load(model.getLargeImageURL()).into(itemBinding.imgImage);
        }
    }
}
