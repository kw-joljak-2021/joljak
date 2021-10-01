package com.example.preapp;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class practice1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice1);
        ProgressBar bar1 = (ProgressBar) findViewById(R.id.bar1);
        ProgressBar bar2 = (ProgressBar) findViewById(R.id.bar2);
    }
}
