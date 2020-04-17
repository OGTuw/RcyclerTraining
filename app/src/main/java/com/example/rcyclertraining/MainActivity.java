package com.example.rcyclertraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewControl recyclerViewControl = new RecyclerViewControl();

        getSupportFragmentManager().beginTransaction().replace(R.id.a_video_actress_list, recyclerViewControl).commit();
    }
}
