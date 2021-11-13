package com.example.preapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class practice1 extends AppCompatActivity {

    Button consonant, vowel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice1);
        setTitle("연습");
        
        Button consonant = (Button) findViewById(R.id.consonant);
        Button vowel = (Button) findViewById(R.id.vowel);



        // 자음 버튼 연결
        consonant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(practice1.this, consonant.class);
                startActivity(intent);
            }
        });

        // 모음 버튼 연결
        vowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(practice1.this, vowel.class);
                startActivity(intent2);
            }
        });
    }
}
