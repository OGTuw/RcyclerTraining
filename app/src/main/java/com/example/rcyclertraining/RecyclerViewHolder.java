package com.example.rcyclertraining;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    RecyclerViewHolder(View v) {
        super(v);
        imageView = v.findViewById(R.id.picture);
        textView = v.findViewById(R.id.name);
    }
}

