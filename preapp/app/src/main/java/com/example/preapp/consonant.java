package com.example.preapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class consonant extends AppCompatActivity {


    Button[] consonantBtn = new Button[13];
    Intent[] intent = new Intent[13];
    Integer[] consonantBtnId = {R.id.r, R.id.s, R.id.e, R.id.f, R.id.a, R.id.q, R.id.t,
            R.id.d, R.id.w, R.id.c, R.id.z, R.id.x, R.id.v, R.id.g};
    int[] imgs = new int[]{R.drawable.r, R.drawable.s,R.drawable.e,R.drawable.f,R.drawable.a,R.drawable.q,
            R.drawable.t,R.drawable.d,R.drawable.w,R.drawable.c,R.drawable.z,R.drawable.x,R.drawable.v,R.drawable.g};

    void init()
    {
        for(int i=0;i<consonantBtn.length;i++)
        {
            consonantBtn[i]=(Button) findViewById(consonantBtnId[i]);
        }

    }

    void Click_Btn(int i)
    {
        consonantBtn[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[i] = new Intent(getApplicationContext(), practice_camera.class);
                intent[i].putExtra("idr", consonantBtnId[i]);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs[i]);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent[i].putExtra("image", byteArray);
                startActivity(intent[i]);
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consonant);
        setTitle("자음");
        init();
        for(int i=0;i<consonantBtn.length;i++)
        {
            Click_Btn(i);
        }
    }



    }
