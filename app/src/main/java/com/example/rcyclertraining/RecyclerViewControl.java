package com.example.rcyclertraining;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewControl extends Fragment {

    private static final Integer[] picture = {
            R.drawable.eiro, R.drawable.mitani,
            R.drawable.uehara, R.drawable.fukada,
            R.drawable.suzumori, R.drawable.anzai,
            R.drawable.kawai, R.drawable.kuruki,
            R.drawable.matsushita, R.drawable.matsumoto
    };

    private static final String[] name = {
            "絵色千佳", "美谷朱里", "上原亜衣",
            "深田えいみ", "涼森れむ", "安斎らら",
            "河合あすな", "久留木玲", "松下紗栄子", "松本いちか"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycleview_main,null);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        List<Integer> itemPicture = new ArrayList<>(Arrays.asList(picture));
        List<String> itemName = new ArrayList<>(Arrays.asList(name));

        RecyclerView.Adapter rAdapter = new RecyclerViewAdapter(itemPicture, itemName);
        recyclerView.setAdapter(rAdapter);

        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }
}
