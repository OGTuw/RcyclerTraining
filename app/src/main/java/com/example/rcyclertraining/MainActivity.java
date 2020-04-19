package com.example.rcyclertraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    RecyclerViewControl recyclerViewControl = new RecyclerViewControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, recyclerViewControl).commit();
    }

    public void onActivityReenter(int resultCode, Intent data) {
        FragmentDetail detail = new FragmentDetail();
        RecyclerViewControl rv = new RecyclerViewControl();
        Serializable run = data.getDataString();

        switch((String)run) {
            case "Home":
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, recyclerViewControl).commit();
            break;

            case "Change":
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, detail).commit();
            break;

            default:
            Toast.makeText(rv.getContext(), "null", Toast.LENGTH_LONG).show();
        }
    }
}
