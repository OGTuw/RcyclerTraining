package com.example.rcyclertraining;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Integer> pictures;
    private List<String> names;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.picture);
            textView = v.findViewById(R.id.name);
        }
    }

    RecyclerViewAdapter(List itemPictures, List itemNames) {
        this.pictures = itemPictures;
        this.names = itemNames;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.imageView.setImageResource(pictures.get(position));
        vh.textView.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
