package com.example.preapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    Button practice, real, game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        practice = (Button) findViewById(R.id.practice);
        real = (Button) findViewById(R.id.real);
        game = (Button) findViewById(R.id.game);


        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, practice1.class);
                startActivity(intent);
            }
        });


    }
}
