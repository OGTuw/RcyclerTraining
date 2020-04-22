package com.example.rcyclertraining;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class FragmentDetail extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // R.layout.Fragment(xml)のファイル名
        return inflater.inflate(R.layout.fragment_detail, null);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnReturn = getView().findViewById(R.id.button_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewControl control = new RecyclerViewControl();
                getFragmentManager().beginTransaction().replace(R.id.frame_main, control).commit();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerViewControl control = new RecyclerViewControl();
        Bundle bundle = new Bundle();
        Integer picture[] = control.picture;
        String name[] = control.name;
        String size[] = control.size;
        int index = bundle.getInt("Index");

        TextView textName = view.findViewById(R.id.text_name);
        ImageView img = view.findViewById(R.id.image_picture);
        TextView textSize = view.findViewById(R.id.text_three_size);

        textName.setText(name[index]);
        Glide.with(getContext()).load(picture[index]).into(img);
        textSize.setText(size[index]);
    }


}
