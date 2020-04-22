package com.example.rcyclertraining;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewControl extends Fragment {

    public static final Integer[] picture = {
            R.drawable.eiro, R.drawable.mitani,
            R.drawable.uehara, R.drawable.fukada,
            R.drawable.suzumori, R.drawable.anzai,
            R.drawable.kawai, R.drawable.kuruki,
            R.drawable.matsushita, R.drawable.matsumoto
    };

    public static final String[] name = {
            "絵色千佳", "美谷朱里", "上原亜衣",
            "深田えいみ", "涼森れむ", "安斎らら",
            "河合あすな", "久留木玲", "松下紗栄子", "松本いちか"
    };

    public static final String[] size = {
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

        final RecyclerView recyclerView = view.findViewById(R.id.a_video_actress_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        RecyclerViewAdapter rAdapter = new RecyclerViewAdapter(createRow());
        recyclerView.setAdapter(rAdapter);

        rAdapter.setOnItemClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // ここで必要になるViewはViewHolderのitemView
                int index = recyclerView.getChildAdapterPosition(view);
                Bundle bundle = new Bundle();
                bundle.putInt("Index", index);
                FragmentDetail detail = new FragmentDetail();
                detail.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.frame_main, detail).commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    }

    private List<Row> createRow() {
        List<Row> rowData = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Row row = new Row();
            row.setName(name[i]);
            row.setPicture(picture[i]);

            rowData.add(row);
        }
        return rowData;
    }
}