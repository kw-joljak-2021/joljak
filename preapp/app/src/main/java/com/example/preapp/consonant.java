package com.example.preapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class consonant extends AppCompatActivity {

    Button r;

   /* Button[] consonantBtn = new Button[13];
    Integer[] consonantBtnId = {R.id.r, R.id.s, R.id.e, R.id.f, R.id.a, R.id.q, R.id.t,
            R.id.d, R.id.w, R.id.c, R.id.z, R.id.x, R.id.v, R.id.g};
    int i;*/

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consonant);
        setTitle("자음");

        r = (Button) findViewById(R.id.r);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(consonant.this, practice_camera.class);
                startActivity(intent);
            }
        });

        /*// 버튼 객체 생성
        for (i = 0; i < consonantBtnId.length; i++){
            consonantBtn[i] = (Button) findViewById(consonantBtnId[i]);
        }*/

        /*for(i = 0; i < consonantBtnId.length; i++){
            final int index;
            index = i;

            consonantBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(consonant.this, practice_camera.class);
                    startActivity(intent);
                }
            });
        }*/



    }
}
